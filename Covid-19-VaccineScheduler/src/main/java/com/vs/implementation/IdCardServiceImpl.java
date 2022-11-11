package com.vs.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vs.exception.IdCardException;
import com.vs.model.Idcard;
import com.vs.repo.IdCardRepo;
import com.vs.service.IdCardService;

@Service
public class IdCardServiceImpl implements IdCardService{
	@Autowired
	private IdCardRepo idCardRepo;
	
	@Override
	public Idcard getPanCardByNumber(String panNo) throws IdCardException{
		Idcard idcard=idCardRepo.findByPanCardNo(panNo);
		if(idcard!=null) {
			return idcard;
		}else {
			throw new IdCardException("Id card not found with pan no - "+panNo);
		}
	}

	@Override
	public Idcard getAdharCardByNo(Long adharNo) throws IdCardException{
		Idcard idcard=idCardRepo.findByAdharCardNo(adharNo);
		if(idcard!=null) {
			return idcard;
		}else {
			throw new IdCardException("Id card not found with adhar no - "+adharNo);
		}
	}

	@Override
	public Idcard addIdCard(Idcard idCard) throws IdCardException{
		Idcard idcard=idCardRepo.save(idCard);
		if(idcard!=null) {
			return idcard;
		}else {
			throw new IdCardException("Id card not added");
		}
	}

}
