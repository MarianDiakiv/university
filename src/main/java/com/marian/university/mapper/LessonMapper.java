package com.marian.university.mapper;

import com.marian.university.dto.LessonDTO;
import com.marian.university.entity.Lesson;
import com.marian.university.entity.StudentDetails;
import com.marian.university.entity.TeacherDetail;
import com.marian.university.repository.LessonRepository;
import com.marian.university.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;

public class LessonMapper  {
    @Autowired
    private LessonRepository lessonRepository;

    private LessonService lessonService;
    public LessonDTO lessonToDto(Lesson lesson){
        LessonDTO lessonDTO = new LessonDTO();
        lessonDTO.setId(lesson.getId());
        lessonDTO.setDatelesson(lesson.getDatelesson());
        lessonDTO.setTimelesson(lesson.getTimelesson());
        lessonDTO.setTimeLessonEnd(lesson.getTimeLessonEnd());
        lessonDTO.setStatus(lesson.isStatus());
        lessonDTO.setSubjectId(lesson.getSubject().getId());
        StudentDetails studentDetails = lesson.getStudentDetails();
        if (studentDetails!=null){
            lessonDTO.setStudentDetailsId(studentDetails.getId());
        }else {
            lessonDTO.setStudentDetailsId(0);
        }
        TeacherDetail teacherDetail = lesson.getTeacherDetail();
        if (teacherDetail!=null){
            lessonDTO.setTeacherDetailsId(teacherDetail.getId());
            }else {
            lessonDTO.setTeacherDetailsId(0);
        }
        return lessonDTO;
    }
    public Lesson dtoToLesson(LessonDTO dto){
        Lesson lesson = new Lesson();
        lesson.setId(dto.getId());
        lesson.setDatelesson(dto.getDatelesson());
        lesson.setTimelesson(dto.getTimelesson());
        lesson.setTimeLessonEnd(dto.getTimeLessonEnd());
        lesson.setStatus(dto.isStatus());
//        if(dto.getTeacherDetailsId()!=0 && dto.getId()!=0) {
//            lesson.setTeacherDetail(lessonService.getById(dto.getId()).getTeacherDetail());
//        }
//        if (dto.getStudentDetailsId()!=0&&dto.getId()!=0){
//            lesson.setStudentDetails(lessonService.getById(dto.getId()).getStudentDetails());
//        }
        return lesson;

    }
}
