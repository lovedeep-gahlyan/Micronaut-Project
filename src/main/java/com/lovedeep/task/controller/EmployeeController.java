package com.lovedeep.task.controller;
import com.lovedeep.task.service.EmployeeService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import jakarta.inject.Inject;
import io.micronaut.http.multipart.CompletedFileUpload;

import java.io.File;

@Controller
public class EmployeeController {

    @Inject
    private EmployeeService employeeService;

    @Post(value = "/upload",consumes = MediaType.MULTIPART_FORM_DATA)
    public HttpResponse<String> addDataToSql(@Body CompletedFileUpload file){
        employeeService.importDataFromExcel((File) file);
        return HttpResponse.ok("Employee Added");
    }
}
