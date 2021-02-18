package com.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.model.CardInformation;
import com.repository.CardRepository;
import com.entity.CardHitDetail;

@Service
public class CardServiceImpl implements CardService {
	private final String thridPartyURL="https://lookup.binlist.net/";
	
	@Autowired
	CardRepository cardRepository;
	
	
	@Override
	public ResponseEntity<CardInformation> getDetails(final String cardId) {
		
		RestTemplate restTemplate = new RestTemplate();
		String resourceUrl = thridPartyURL.concat(cardId);
		
		CardInformation cardInfo;
		ResponseEntity<CardInformation> response;
		
		try {
			cardInfo= restTemplate.getForObject(resourceUrl , CardInformation.class);
			response=new ResponseEntity<>(cardInfo,HttpStatus.OK);
		}catch(Exception e){
			response=new ResponseEntity<>(HttpStatus.NOT_FOUND);
			return response;
		}
		
		updateHitCount(cardId);
//		
//		System.out.println(cardInfo.toString());
//		System.out.println(cardRepository.findById(cardId).get().toString());
		return response;
		
	}
	
	
	private void updateHitCount(String cardId) { 
		Optional<CardHitDetail>  currentCard=cardRepository.findById(cardId); 
		CardHitDetail  currentCardHitDetail; 
		if(currentCard.isPresent()) {
			currentCardHitDetail=currentCard.get(); 
			currentCardHitDetail.setHitCount(currentCardHitDetail.getHitCount()+1); 
		}
		else { 
			currentCardHitDetail=new CardHitDetail(); 
			currentCardHitDetail.setCardId(cardId); 
			currentCardHitDetail.setHitCount(1);
		}
		
		cardRepository.save(currentCardHitDetail);
	 }
	
	
	@Override
	public List<CardHitDetail> getStats(int start,int limit) {
		List<CardHitDetail> cardList=cardRepository.findStats(limit, start-1);
		return cardList;
	}
	
	
	
}
