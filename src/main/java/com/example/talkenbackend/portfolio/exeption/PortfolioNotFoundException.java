package com.example.talkenbackend.portfolio.exeption;

import com.example.talkenbackend.global.exception.EntityNotFoundException;

public class PortfolioNotFoundException extends EntityNotFoundException {

    public PortfolioNotFoundException() {
        super("포트폴리오를 찾을 수 없습니다.");
    }
}
