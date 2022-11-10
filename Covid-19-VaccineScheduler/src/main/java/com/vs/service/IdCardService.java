package com.vs.service;

import com.vs.exception.IdCardException;
import com.vs.model.Idcard;


public interface IdCardService {
	public Idcard getPanCardByNumber(String panNo) throws IdCardException;
	public Idcard getAdharCardByNo(Long adharNo) throws IdCardException;
	public Idcard addIdCard(Idcard idCard) throws IdCardException;
}
