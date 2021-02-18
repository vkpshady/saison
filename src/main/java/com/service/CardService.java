package com.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.entity.CardHitDetail;
import com.model.CardInformation;

public interface CardService {

	public ResponseEntity<CardInformation> getDetails(final String cardId);
	
	public List<CardHitDetail> getStats(int start,int limit);
}
