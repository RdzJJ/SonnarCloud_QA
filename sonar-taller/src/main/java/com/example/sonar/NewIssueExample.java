package com.example.sonar;

public class NewIssueExample {
    public int compute(int a) {
        int unused = 5; // variable sin usar -> New Issue
        return a * 2;
    }
}
