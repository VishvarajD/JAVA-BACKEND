package com.example.JobPortal.Service;

import com.example.JobPortal.Controller.JobController;
import com.example.JobPortal.Model.JobPost;
import com.example.JobPortal.Repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {
    @Autowired
    JobRepo jobRepo;


    public void addJob(JobPost jp) {
        jobRepo.addJob(jp);

    }

    public List<JobPost> getAllJobs() {
        return jobRepo.getAllJobs();
    }
}
