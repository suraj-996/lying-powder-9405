package com.vs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vs.exception.MemberException;
import com.vs.model.Member;
import com.vs.service.MemberService;

@RestController
@RequestMapping(value = "/member")
public class MemberController {

	@Autowired
	private MemberService memberService;

	@GetMapping(value = "/members")
	public ResponseEntity<List<Member>> getAllMembers() throws MemberException {

		List<Member> members = memberService.getAllMembers();

		return new ResponseEntity<List<Member>>(members, HttpStatus.OK);

	}

	@GetMapping(value = "/members/{memberId}")
	public ResponseEntity<Member> getMemberById(@PathVariable("memberId") Integer memberId) throws MemberException {

		Member member = memberService.getMemberById(memberId);

		return new ResponseEntity<Member>(member, HttpStatus.OK);

	}

//	@GetMapping(value = "/membersbyaadhar/{aadhar}")
//	public ResponseEntity<Member> getMemberByAadharNo(@PathVariable("aadhar") Long aadharNo) throws MemberException {
//
//		Member member = memberService.getMemberByAadharNo(aadharNo);
//
//		return new ResponseEntity<Member>(member, HttpStatus.OK);
//
//	}
//
//	@GetMapping(value = "/membersbypan/{pan}")
//	public ResponseEntity<Member> getMemberByPanNo(@PathVariable("pan") String panNo) throws MemberException {
//
//		Member member = memberService.getMemberByPanNo(panNo);
//
//		return new ResponseEntity<Member>(member, HttpStatus.OK);
//
//	}

	@PostMapping(value = "/members")
	public ResponseEntity<Member> addMember(@RequestBody Member member) throws MemberException {

		Member addedMember = memberService.addMember(member);

		return new ResponseEntity<Member>(addedMember, HttpStatus.OK);

	}

	@PutMapping(value = "/members")
	public ResponseEntity<Member> updateMember(@RequestBody Member member) throws MemberException {

		Member updatedMember = memberService.updateMember(member);

		return new ResponseEntity<Member>(updatedMember, HttpStatus.OK);

	}

	@DeleteMapping(value = "/members")
	public ResponseEntity<Boolean> deleteMember(@RequestBody Member member) throws MemberException {

		Boolean ans = memberService.deleteMember(member);

		return new ResponseEntity<Boolean>(ans, HttpStatus.OK);

	}

}
