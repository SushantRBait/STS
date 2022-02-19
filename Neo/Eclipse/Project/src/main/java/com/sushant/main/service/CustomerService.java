package com.sushant.main.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sushant.main.controller.CustomerController;
import com.sushant.main.dto.CustomerDTO;
import com.sushant.main.dto.CustomerSimDTO;
import com.sushant.main.dto.SimDTO;
import com.sushant.main.model.Customer;
import com.sushant.main.model.Sim;
import com.sushant.main.repository.CustomerRepository;
import com.sushant.main.repository.SimRepository;

@Service
public class CustomerService {

    Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
     CustomerRepository customerRepository;
    
    @Autowired
     SimRepository simRepository;
   
    
    public String save(CustomerDTO customerDTO) {
        logger.info("Saving the customer");
        Customer customer = new Customer();
        customer.setCustId(customerDTO.getCustId());
        customer.setAddress(customerDTO.getAddress());
        customer.setDOB(customerDTO.getDOB());
        customer.setName(customerDTO.getName());
        customer.setEmail(customerDTO.getEmail());

        customerRepository.save(customer);
        logger.info("customer saved successfully");
        return "Customer Saved Successfully";
    }

    public String createSim(List<SimDTO> sim) {
        logger.info("Saving the Sim");
        List<Sim> sims = new ArrayList<>();
        for (SimDTO simDTO : sim) {
            Sim simEntity = new Sim();
            simEntity.setCustomer(customerRepository.findById(simDTO.getCustId()).get());
            simEntity.setSimNo(simDTO.getSimNo());
          //  simEntity.setMobileNo(simDTO.getMobileNo());
            simEntity.setCompany(simDTO.getCompany());
            sims.add(simEntity);
        }
        simRepository.saveAll(sims);
        logger.info("Sim saved successfully");
        return "Sim Save Successfully";
    }

    public List<SimDTO> getAllSim() {
        logger.info("Fetching Sims..... ");
        List<SimDTO> simDTOS = new ArrayList<>();
        List<Sim> all = simRepository.findAll();
        for (Sim s : all) {
            SimDTO simDTO = new SimDTO();
            simDTO.setSimId(s.getSimId());
            simDTO.setCompany(s.getCompany());
            simDTO.setSimNo((s.getSimNo()));
           // simDTO.setCustId(s.getCustomer().getCustId());
            simDTOS.add(simDTO);
        }
        return simDTOS;
    }

    public List<SimDTO> getSims(Integer custId) {
        Customer customer = customerRepository.findById(custId).get();
        List<Sim> simCards = customer.getSimCards();
        List<SimDTO> simDTOS = new ArrayList<>();
        logger.info("Fetching the sim using customer id ...");
        for (Sim s : simCards) {
            SimDTO simDTO = new SimDTO();
            simDTO.setSimId(s.getSimId());
            simDTO.setCompany(s.getCompany());
            simDTO.setPUC(s.getPUC());
            simDTO.setCustId(s.getCustomer().getCustId());
            simDTOS.add(simDTO);
        }
        return simDTOS;
    }


    public String[] getMailAfterSevenDay() {
        return customerRepository.getCustomer().stream().map(e->e.getEmail()).collect(Collectors.toList()).toArray(String[]::new);

    }

    public ByteArrayInputStream dailyExport() {
        List<Customer> collect = customerRepository.getCustomersListOneDayBeforeBirthday();
        logger.info("dailyExport Method executed...");
        List<CustomerSimDTO> customerSimDTOS = new ArrayList<>();
        for (Customer c : collect) {
            List<Long> nums = new ArrayList<>();
            for (Sim sim : c.getSimCards()) {
            	nums.add(sim.getSimNo());
            }
            String Num = nums.stream().map(String::valueOf).collect(Collectors.joining(","));
            CustomerSimDTO customerSimDTO = new CustomerSimDTO();
            customerSimDTO.setCustId(c.getCustId());
            customerSimDTO.setAddress(c.getAddress());
            customerSimDTO.setName(c.getName());
            customerSimDTO.setEmail(c.getEmail());
            customerSimDTO.setDOB(c.getDOB());
            customerSimDTOS.add(customerSimDTO);
        }

        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Daily Export");

            Row row = sheet.createRow(0);

            // Define header cell style
            CellStyle headerCellStyle = workbook.createCellStyle();
            headerCellStyle.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
            headerCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            // Creating header cells
            Cell cell = row.createCell(0);
            cell.setCellValue("Customer Id");
            cell.setCellStyle(headerCellStyle);

            cell = row.createCell(1);
            cell.setCellValue("Name");
            cell.setCellStyle(headerCellStyle);

            cell = row.createCell(2);
            cell.setCellValue("Email");
            cell.setCellStyle(headerCellStyle);

            cell = row.createCell(3);
            cell.setCellValue("Address");
            cell.setCellStyle(headerCellStyle);

            cell = row.createCell(4);
            cell.setCellValue("Mobile Number");
            cell.setCellStyle(headerCellStyle);

            cell = row.createCell(5);
            cell.setCellValue("Date Of Birth");
            cell.setCellStyle(headerCellStyle);

            // Creating data rows
            for (int i = 0; i < customerSimDTOS.size(); i++) {
                Row dataRow = sheet.createRow(i + 1);
                dataRow.createCell(0).setCellValue(customerSimDTOS.get(i).getCustId());
                dataRow.createCell(1).setCellValue(customerSimDTOS.get(i).getName());
                dataRow.createCell(2).setCellValue(customerSimDTOS.get(i).getEmail());
                dataRow.createCell(3).setCellValue(customerSimDTOS.get(i).getAddress());
                dataRow.createCell(4).setCellValue(customerSimDTOS.get(i).getMobileNo());
                dataRow.createCell(5).setCellValue(customerSimDTOS.get(i).getDOB().toString());
            }

            sheet.autoSizeColumn(0);
            sheet.autoSizeColumn(1);
            sheet.autoSizeColumn(2);
            sheet.autoSizeColumn(3);
            sheet.autoSizeColumn(4);
            sheet.autoSizeColumn(5);

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            workbook.write(outputStream);
            return new ByteArrayInputStream(outputStream.toByteArray());
        } catch (IOException ex) {
            logger.error("Error during export Excel file", ex);
            return null;
        }

    }


}
