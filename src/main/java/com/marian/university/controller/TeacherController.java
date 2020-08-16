package com.marian.university.controller;

import com.marian.university.dto.FreeTeachersTimeDTO;
import com.marian.university.dto.LessonDTO;
import com.marian.university.dto.SubjectDTO;
import com.marian.university.dto.TeacherLessonPriceDTO;
import com.marian.university.entity.*;
import com.marian.university.mapper.FreeTeachersTimeMapper;
import com.marian.university.mapper.LessonMapper;
import com.marian.university.mapper.SubjectMapper;
import com.marian.university.mapper.TeachersLessonPriceMapper;
import com.marian.university.payload.responce.MessageResponse;
import com.marian.university.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/open")
public class TeacherController {

    /*@Autowired
    private TeacherDetailRepository teacherDetailRepository;*/
    @Autowired
private SubjectService subjectService;
    @Autowired
    private FreeTeachersTimeService freeTeachersTimeService;
    @Autowired
    private TeacherDetailService teacherDetailService;
    @Autowired
    private TeacherLessonPriceService teacherLessonPriseService;

    @Autowired
    private LessonService lessonService;
    @Autowired
    private StudentServcie studentServcie;


//    private FreeTeachersTimeDTO freeTeachersTimeDTO(){
//        FreeTeachersTimeMapper freeTeachersTimeMapper = new FreeTeachersTimeMapper();
//
//    }
// для всіх ролей
    @GetMapping("/allSubject")
    public List<SubjectDTO> getSubject(){
        List<Subject> subjects = subjectService.getAll();
        List<SubjectDTO> subjectDTOS = new ArrayList<>();
        for (Subject s :subjects){
            SubjectMapper mapper = new SubjectMapper();
            SubjectDTO dto = mapper.subjectToDto(s);
            subjectDTOS.add(dto);
        }
        return subjectDTOS;
    }
    @PostMapping("/createSubject")
    public MessageResponse createSubject(@RequestBody SubjectDTO dto){
        System.out.println(dto.getId()+" name " + dto.getNameSubject());
        Subject subject =  subjectService.getSubjectByName(dto.getNameSubject());
        MessageResponse messageResponse;
        if (subject!=null){
             messageResponse = new MessageResponse("This subject exist");
        }else
        {
            SubjectMapper mapper = new SubjectMapper();
            Subject subject1 = mapper.dtoToSubject(dto);
            subjectService.save(subject1);
            messageResponse = new MessageResponse("created");
        }

        return messageResponse;
    }

    @GetMapping("/getTimeByTeacherDetid/{id}")
    public List<FreeTeachersTimeDTO> freeTeachersTimeDTO(@PathVariable("id") int id){
        TeacherDetail teacherDetail = teacherDetailService.getById(id);
        List<FreeTeachersTime>  timeList = freeTeachersTimeService.getByTeacherDetails(teacherDetail);
        List<FreeTeachersTimeDTO> dtos = new ArrayList<>();

        FreeTeachersTimeMapper mapper = new FreeTeachersTimeMapper();
        for (FreeTeachersTime f: timeList){
            dtos.add(mapper.freeTeachersTimeToDto(f));
        }
        return dtos;
    }
//@GetMapping("/getTimeByTeacherDetid/{id}")
//public List<FreeTeachersTime> freeTeachersTimeDTO(@PathVariable("id") int id){
//    TeacherDetail teacherDetail = teacherDetailService.getById(id);
//    List<FreeTeachersTime>  timeList = freeTeachersTimeService.getByTeacherDetails(teacherDetail);
////    List<FreeTeachersTimeDTO> dtos = new ArrayList<>();
//
//    /*FreeTeachersTimeMapper mapper = new FreeTeachersTimeMapper();
//    for (FreeTeachersTime f: timeList){
//        dtos.add(mapper.freeTeachersTimeToDto(f));
//    }*/
//    return timeList;
//}
@PostMapping("/createFreeTime")
public MessageResponse creaeFreeTime(@RequestBody FreeTeachersTimeDTO dto){
        FreeTeachersTimeMapper mapper = new FreeTeachersTimeMapper();
        FreeTeachersTime time = mapper.dtoToFreeTeachersTime(dto);
        time.setTeacherDetail(teacherDetailService.getById(dto.getTeacherDetailsId()));
        freeTeachersTimeService.save(time);
        return new  MessageResponse("Збережено");
}
@GetMapping("/teacherlessonPrise/{id}")
public List<TeacherLessonPriceDTO>  teacherLessonPriceDTO(@PathVariable("id") int id){
        TeacherDetail detail = teacherDetailService.getById(id);
        List<TeacherLessonPrice> teacherLessonPrices= teacherLessonPriseService.getByTeacher(detail);
        ArrayList<TeacherLessonPriceDTO> dtos = new ArrayList<>();
        for (TeacherLessonPrice t:teacherLessonPrices){
            TeachersLessonPriceMapper mapper = new TeachersLessonPriceMapper();
            dtos.add(mapper.teacherLessonPriceToDto(t));
        }
        return dtos;
}
@PostMapping("/teacherlessonPrise")
public MessageResponse createPriseForTeacher(@RequestBody TeacherLessonPriceDTO dto){
        TeachersLessonPriceMapper mapper = new TeachersLessonPriceMapper();
        TeacherLessonPrice price = mapper.dtoToteacherLessonPrice(dto);
        price.setTeacherDetail(teacherDetailService.getById(dto.getTeacherDetailsId()));
        price.setSubjectT(subjectService.getBuId(dto.getSubjectid()));
        teacherLessonPriseService.save(price);

        return new MessageResponse("OK");
}
// Test controller
@GetMapping("/teachersLesson/{id}")
    public List<LessonDTO> getLessonyTeacherAndStatusTrue(@PathVariable("id") int id){
        TeacherDetail teacherDetail = teacherDetailService.getById(id);
        List<Lesson> lessons = lessonService.getLessonByTeacherDetail(teacherDetail);
        List<LessonDTO> dtos = new ArrayList<>();
        for (Lesson l:lessons){
            LessonMapper mapper = new LessonMapper();
            LessonDTO dto = mapper.lessonToDto(l);
            dtos.add(dto);
        }
        return dtos;
    }
    @GetMapping("getTeacherStatusFalseLesson/{id}/{status}")
    public List<LessonDTO> getLessonByFalseStatus(@PathVariable("id") int id,@PathVariable("status") boolean st){
        TeacherDetail detail = teacherDetailService.getById(id);
        List<Lesson> lessons= lessonService.getLessonByTeacherDetailAndStatus(detail,st);

        List<LessonDTO> dtos = new ArrayList<>();
        for (Lesson l:lessons){
            LessonMapper mapper = new LessonMapper();
            LessonDTO dto = mapper.lessonToDto(l);
            dtos.add(dto);
        }
        return dtos;
    }
    @GetMapping("/acceptLesson/{id}/{status}")
public MessageResponse acceptLesson(@PathVariable("id") int id,@PathVariable("status") boolean status){
        Lesson lesson = lessonService.getById(id);
        lesson.setStatus(status);
        return lessonService.update(lesson);
}
// for student
@PostMapping("/createLesson")
public MessageResponse createTeacherLesson(@RequestBody  LessonDTO dto){
        // для студента
    System.out.println("LESSSSS");
    System.out.println("Lesson" + dto.getStudentDetailsId());
    LessonMapper mapper = new LessonMapper();
    Lesson lesson = mapper.dtoToLesson(dto);
    System.out.println("+++++++++" + lesson.getDatelesson());
    lesson.setTeacherDetail(teacherDetailService.getById(dto.getTeacherDetailsId()));
    lesson.setStudentDetails(studentServcie.getById(dto.getStudentDetailsId()));
    lesson.setSubject(subjectService.getBuId(dto.getSubjectId()));
    // Перевірки


return lessonService.save(lesson);
}
}
