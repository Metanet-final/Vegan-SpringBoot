package com.kosa.Catchvegan.Service;

import com.kosa.Catchvegan.DTO.ReviewDTO;
import com.kosa.Catchvegan.Mapper.ReviewMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService{

    @Autowired
    private ReviewMapper mapper;
    @Override
    public ReviewDTO reviewDetail(int visitIdx) {

        return mapper.detailReview(visitIdx);
    }

    @Override
    public void reviewCreate(ReviewDTO reviewDTO) {
        mapper.createReview(reviewDTO);
    }

    @Override
    public void reviewUpdate(ReviewDTO reviewDTO) {
        mapper.updateReview(reviewDTO);
    }

    @Override
    public void reviewDelete(int reviewIdx) {
        mapper.deleteReview(reviewIdx);
    }


}