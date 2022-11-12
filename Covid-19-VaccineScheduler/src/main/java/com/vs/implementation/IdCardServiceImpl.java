package com.vs.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vs.exception.IdCardException;
import com.vs.exception.UserException;
import com.vs.model.CurrentUserSession;
import com.vs.model.Idcard;
import com.vs.repo.IdCardRepo;
import com.vs.repo.UserSessionRepo;
import com.vs.service.IdCardService;

@Service
public class IdCardServiceImpl implements IdCardService {
	@Autowired
	private IdCardRepo idCardRepo;

	@Autowired
	private UserSessionRepo userSessionRepo;

	@Override
	public Idcard getPanCardByNumber(String panNo, String key) throws IdCardException, UserException {

		CurrentUserSession currentUser = userSessionRepo.findByuuid(key);

		if (currentUser != null) {

			Idcard idcard = idCardRepo.findByPanCardNo(panNo);
			if (idcard != null) {
				return idcard;
			} else {
				throw new IdCardException("Id card not found with pan no - " + panNo);
			}
		} else
			throw new UserException("Opps...!!! Login as a user first.");
	}

	@Override
	public Idcard getAdharCardByNo(Long adharNo, String key) throws IdCardException, UserException {

		CurrentUserSession currentUser = userSessionRepo.findByuuid(key);

		if (currentUser != null) {

			Idcard idcard = idCardRepo.findByAdharCardNo(adharNo);
			if (idcard != null) {
				return idcard;
			} else {
				throw new IdCardException("Id card not found with adhar no - " + adharNo);
			}
		} else
			throw new UserException("Opps...!!! Login as a user first.");
	}

	@Override
	public Idcard addIdCard(Idcard idCard, String key) throws IdCardException, UserException {

		CurrentUserSession currentUser = userSessionRepo.findByuuid(key);

		if (currentUser != null) {

			Idcard idcard = idCardRepo.save(idCard);
			if (idcard != null) {
				return idcard;
			} else {
				throw new IdCardException("Id card not added");
			}
		} else
			throw new UserException("Opps...!!! Login as a user first.");
	}

}
