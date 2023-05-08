package ks46team04.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ks46team04.admin.dto.Funding;
import ks46team04.admin.mapper.FundingDetailMapper;

@Controller
@RequestMapping("/common/funding_detail")
public class FundingDetailController {
	 
	
	private final FundingDetailMapper fundingDetailMapper;

	public FundingDetailController(FundingDetailMapper fundingDetailMapper) {

	    this.fundingDetailMapper = fundingDetailMapper;
	}

	@GetMapping("/{fundingCode}")
    public String getFundingDetail(@RequestParam("fundingCode") String fundingCode, Model model) {
        Funding funding = fundingDetailMapper.selectFundingByCode(fundingCode);
        model.addAttribute("funding", funding);
        return "common/funding_detail";
    }
}

