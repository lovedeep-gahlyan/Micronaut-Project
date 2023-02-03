package com.lovedeep.task.service;

import com.lovedeep.task.model.Employee;
import com.lovedeep.task.repo.EmployeeRepo;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.apache.poi.xssf.usermodel.*;
import java.io.FileInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;

@Singleton
public class EmployeeService {

   @Inject
   private EmployeeRepo employeeRepo;

    public void importDataFromExcel(File file){
            try(FileInputStream fileInputStream = new FileInputStream(file)){


                XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
                XSSFSheet sheet = workbook.getSheetAt(0);

                for(Row row:sheet) {
                    String name = row.getCell(0).getStringCellValue();
                    String address = row.getCell(1).getStringCellValue();
                    String designation = row.getCell(2).getStringCellValue();

                    Employee employee = new Employee();
                    employee.setName(name);
                    employee.setAddress(address);
                    employee.setDesignation(designation);

                    employeeRepo.save(employee);
                }
                } catch (FileNotFoundException e) {

                System.out.println("File not found: " + e.getMessage());
            } catch (IOException e) {

                System.out.println("Error reading file: " + e.getMessage());
            } catch (Exception e) {

                System.out.println("Error: " + e.getMessage());
            }
            }

    }