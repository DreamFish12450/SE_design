package cn.cy.service;

import cn.cy.domain.Image;
import cn.cy.domain.Result;

public interface FaceSearch {
    Result faceLogin(Image image);
}
