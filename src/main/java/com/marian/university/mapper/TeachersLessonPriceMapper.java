package com.marian.university.mapper;

import com.marian.university.dto.TeacherLessonPriceDTO;
import com.marian.university.entity.TeacherLessonPrice;
import com.marian.university.repository.TeacherLessonPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class TeachersLessonPriceMapper {
    @Autowired
    private TeacherLessonPriceRepository teacherLessonPriceRepository;

    public TeacherLessonPriceDTO teacherLessonPriceToDto(TeacherLessonPrice lessonPrice){
        TeacherLessonPriceDTO dto = new TeacherLessonPriceDTO();
        dto.setId(lessonPrice.getId());
        dto.setPrice(lessonPrice.getPrice());
        dto.setTime(lessonPrice.getTyme());
        dto.setSubjectid(lessonPrice.getSubjectT().getId());
        dto.setTeacherDetailsId(lessonPrice.getTeacherDetail().getId());
        return dto;
    }
    public TeacherLessonPrice dtoToteacherLessonPrice(TeacherLessonPriceDTO dto){
        TeacherLessonPrice teacherLessonPrice = new TeacherLessonPrice();
        teacherLessonPrice.setId(dto.getId());
        teacherLessonPrice.setPrice(dto.getPrice());
        teacherLessonPrice.setTyme(dto.getTime());
        /*TeacherLessonPrice price = teacherLessonPriceRepository.getOne(dto.getId());
        if (price!=null) {
            teacherLessonPrice.setTeacherDetail(price.getTeacherDetail());
            teacherLessonPrice.setSubjectT(price.getSubjectT());
        }*/
        return teacherLessonPrice;
    }
}
