package com.marian.university.mapper;

import com.marian.university.dto.SubjectDTO;
import com.marian.university.entity.Subject;
import com.marian.university.repository.SubjectRepository;
import com.marian.university.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;

public class SubjectMapper {

    @Autowired
    private SubjectService subjectRepository;

    public SubjectDTO subjectToDto(Subject subject){
        SubjectDTO subjectDTO = new SubjectDTO();
        subjectDTO.setId(subject.getId());
        subjectDTO.setNameSubject(subject.getNamesubject());
        return subjectDTO;
    }
    public Subject dtoToSubject(SubjectDTO dto){
        Subject subject = new Subject();
        subject.setNamesubject(dto.getNameSubject());
        subject.setId(dto.getId());
        if (dto.getId()!=0){
            Subject subject1 = subjectRepository.getBuId(dto.getId());
            subject.setLessonList(subject1.getLessonList());
            subject.setTeacherLessonPriceList(subject1.getTeacherLessonPriceList());
        }

        return subject;
    }
}
