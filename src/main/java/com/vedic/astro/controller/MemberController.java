package com.vedic.astro.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vedic.astro.dto.MemberDTO;
import com.vedic.astro.dto.MemberSummaryDTO;
import com.vedic.astro.enums.MemberType;
import com.vedic.astro.exception.BusinessException;
import com.vedic.astro.exception.SystemException;
import com.vedic.astro.service.MemberService;

/**
 * The Main controller which handles all the incoming GET and POST RESTFul web
 * service calls.
 * 
 * @author Sumeer Saxena
 */
@RestController
@RequestMapping("/api")
final public class MemberController extends BaseController {

	@Autowired
	@Qualifier("memberService")
	private MemberService memberService;

	@RequestMapping(value = "/member/save", method = RequestMethod.POST)
	public RestServiceResponse<String> add(@RequestBody @Valid MemberDTO memberDTO) {
		
		memberService.saveMember(memberDTO);
		String success = "Member successfully saved";
		return new RestServiceResponse<String>(success);
	}

	@RequestMapping(value = "/member/get/{id}", method = RequestMethod.GET)
	public RestServiceResponse<MemberDTO> get(@PathVariable String id)
			throws BusinessException, SystemException {
		
		MemberDTO memberDTO = memberService.getMember(id);
		return new RestServiceResponse<MemberDTO>(memberDTO);
	}
	
	@RequestMapping(value = "/members/all", method = RequestMethod.GET)
	public RestServiceResponse<List<MemberSummaryDTO>> getAll()
			throws BusinessException, SystemException {
		
		List<MemberSummaryDTO> memberDTOList = memberService.getAllMembersSummary();
		return new RestServiceResponse<List<MemberSummaryDTO>>(memberDTOList);
	}
	
	@RequestMapping(value = "/members/{adminId}", method = RequestMethod.GET)
	public RestServiceResponse<List<MemberSummaryDTO>> getAll(@PathVariable String adminId)
			throws BusinessException, SystemException {
		
		List<MemberSummaryDTO> memberDTOList = memberService.getAllMembersSummary(adminId);
		return new RestServiceResponse<List<MemberSummaryDTO>>(memberDTOList);
	}
	
	@RequestMapping(value = "/members/{memberType}/{adminId}", method = RequestMethod.GET)
	public RestServiceResponse<List<MemberSummaryDTO>> getAll(@PathVariable String adminId, @PathVariable MemberType memberType)
			throws BusinessException, SystemException {
		
		List<MemberSummaryDTO> memberDTOList = memberService.getAllMembersSummary(adminId, memberType);
		return new RestServiceResponse<List<MemberSummaryDTO>>(memberDTOList);
	}
	
	@RequestMapping(value = "/members/not/{memberType}/{adminId}", method = RequestMethod.GET)
	public RestServiceResponse<List<MemberSummaryDTO>> getAllNotIn(@PathVariable String adminId, @PathVariable MemberType memberType)
			throws BusinessException, SystemException {
		
		List<MemberSummaryDTO> memberDTOList = memberService.getAllMembersSummaryNotIn(adminId, memberType);
		return new RestServiceResponse<List<MemberSummaryDTO>>(memberDTOList);
	}
}
