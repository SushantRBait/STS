package com.sushant.main.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sushant.main.dto.CustomerDTO;
import com.sushant.main.dto.SimDTO;
import com.sushant.main.service.CustomerService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class CustomerController {
	@Autowired
     CustomerService customerService;

    @GetMapping("/getAllSim")
    public List<SimDTO> getAllSims() {
        return customerService.getAllSim();
    }

    @PostMapping("/customer")
    public String saveCustomer(@RequestBody CustomerDTO customerDTO) {
        return customerService.save(customerDTO);
    }

    @PostMapping("/Sim")
    public String saveSim(@RequestBody List<SimDTO> sim) {
        return customerService.createSim(sim);
    }

    @GetMapping("/getSims/{custId}")
    public List<SimDTO> getSims(@PathVariable Long custId) {
        return customerService.getSims(custId);
    }

    
    @GetMapping("/downloadExcelFile")
    public void downloadExcelFile(HttpServletResponse response) throws IOException {
    	ByteArrayInputStream byteArrayInputStream = customerService.dailyExport();
    	response.setContentType("application/octet-stream");
    	response.setHeader("Content-Disposition", "attachment; filename=CustomerBirthdayList.xlsx");
    	IOUtils.copy(byteArrayInputStream, response.getOutputStream());
    }
}
