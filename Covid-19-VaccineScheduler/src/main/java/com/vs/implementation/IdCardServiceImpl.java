package com.vs.implementation;

import org.springframework.stereotype.Service;

import com.vs.model.Idcard;
import com.vs.repo.IdCardRepo;
import com.vs.service.IdCardService;

@Service
public class IdCardServiceImpl implements IdCardService{
	private IdCardRepo idCardRepo;
	
	@Override
	public Idcard getPanCardByNumber(String panNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Idcard getAdharCardByNo(Long adharNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Idcard addIdCard(Idcard idCard) {
		// TODO Auto-generated method stub
		return null;
	}

}
