package com.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;
import com.entity.CardHitDetail;
import com.model.CardInformation;
import com.service.CardService;


@Controller
public class CardController {


    @Autowired
    CardService cardService;

    /*
    To get Card Details
    */
    @GetMapping("check")
    public ModelAndView check(@ModelAttribute("cardId") String cardId) {
        ModelAndView mv;
        ResponseEntity<CardInformation> cardResponseEntity = cardService.getDetails(cardId);
        CardInformation cardInfo = cardResponseEntity.getBody();

        if (!cardResponseEntity.getStatusCode().equals(HttpStatus.OK)) {
            mv = new ModelAndView("Error");
            mv.addObject("errorMessage", "Invalid CARD Number");
            return mv;
        }

        mv = new ModelAndView("CardInfo");
        populateView(mv, cardInfo);

        return mv;
    }

    /*
    To get Stats of Card Hits
    * */
    @GetMapping("stats")
    public ModelAndView stats(@ModelAttribute("start") int start, @ModelAttribute("limit") int limit) {
        ModelAndView mv;
        if(start<0 || limit<0){
            mv = new ModelAndView("Error");
            mv.addObject("errorMessage", "Enter non-negative value");
            return mv;
        }


        List<CardHitDetail> listOfCards = cardService.getStats(start, limit);

        if (listOfCards.isEmpty()) {
            mv = new ModelAndView("Error");
            mv.addObject("errorMessage", "No stats reocrd found");
            return mv;
        }

        mv = new ModelAndView("Stats");
        mv.addObject("start", start);
        mv.addObject("limit", limit);
        mv.addObject("size", listOfCards.size());
        mv.addObject("list", listOfCards);

        return mv;
    }

    /*
    To redirect to index page
    * */
    @GetMapping("home")
    public String home() {
        return "Index";
    }

    private void populateView(ModelAndView mv, CardInformation cardInfo) {
        if (cardInfo.getBank() != null)
            mv.addObject("bank", cardInfo.getBank().getName());
        else
            mv.addObject("bank", "Bank not Available");


        if (cardInfo.getScheme() != null)
            mv.addObject("scheme", cardInfo.getScheme());
        else
            mv.addObject("scheme", "Scheme Details not available");


        if (cardInfo.getType() != null)
            mv.addObject("type", cardInfo.getType());
        else
            mv.addObject("type", "Type not available");
    }


}
