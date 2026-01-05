package com.example.feedbackapp.controller;

import com.example.feedbackapp.model.Feedback;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class FeedbackController {

    private List<Feedback> feedbackList = new ArrayList<>();

    @GetMapping("/feedback")
    public String feedbackForm(Model model) {
        model.addAttribute("feedback", new Feedback());
        return "feedback";
    }

    @PostMapping("/feedback")
    public String submitFeedback(@ModelAttribute Feedback feedback) {
        feedbackList.add(feedback);
        return "redirect:/feedbacks";
    }

    @GetMapping("/feedbacks")
    public String viewFeedbacks(Model model) {
        model.addAttribute("feedbacks", feedbackList);
        return "feedbacks";
    }
}

