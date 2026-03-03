package com.furnize.bookings.service;

import java.util.List;

import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;

import com.furnize.bookings.exceptions.EmailAlreadyReportedException;
import com.furnize.bookings.exceptions.EmailNotFoundException;
import com.furnize.bookings.exceptions.NoFeedBacksFoundException;
import com.furnize.bookings.model.OrdersFeedBack;
import com.furnize.bookings.repository.FeedBackRepository;

import jakarta.transaction.Transactional;

@Service
public class FeedBackService {
	
	private FeedBackRepository feedBackRepo;
	
	public FeedBackService(FeedBackRepository feedBackRepo) {
		this.feedBackRepo=feedBackRepo;
	}

	public OrdersFeedBack addFeedBack(OrdersFeedBack feedBack) {
		
		if(feedBackRepo.existsByEmail(feedBack.getEmail())) {
			throw new EmailAlreadyReportedException("The Email "+feedBack.getEmail()+" is Already Reported!!");
		}
		
		return feedBackRepo.save(feedBack);
	}

	public List<OrdersFeedBack> getFeedBacks() {
		
		if(feedBackRepo.count()==0) {
			throw new NoFeedBacksFoundException("There is no FeedBack Found");
		}
		return feedBackRepo.findAll();
	}

	@Transactional
	public String deleteFeedBack(String email) {
		
		feedBackRepo.deleteByEmail(email).orElseThrow(()->new EmailNotFoundException("Email Not Found!!"));
		
		return "FeedBack Deleted SuccessFully!!";
		
	}

}
