package com.vs.service;

import com.vs.exception.IdCardException;
import com.vs.exception.UserException;
import com.vs.model.Idcard;

public interface IdCardService {

	public Idcard getPanCardByNumber(String panNo, String key) throws IdCardException, UserException;

	public Idcard getAdharCardByNo(Long adharNo, String key) throws IdCardException, UserException;

	public Idcard addIdCard(Idcard idCard, String key) throws IdCardException, UserException;
}
