package com.marian.university.serviceImpl;

import com.marian.university.entity.FreeTeachersTime;
import com.marian.university.entity.Lesson;
import com.marian.university.entity.TeacherDetail;
import com.marian.university.mail.SendEmail;
import com.marian.university.mapper.FreeTeachersTimeMapper;
import com.marian.university.payload.responce.MessageResponse;
import com.marian.university.repository.FreeTeachersTimeRepository;
import com.marian.university.repository.LessonRepository;
import com.marian.university.service.FreeTeachersTimeService;
import com.marian.university.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class LessonServiceImpl implements LessonService {
    @Autowired
    private LessonRepository repository;

    @Autowired
    private FreeTeachersTimeService freeTeachersTimeService;
    @Override
    public MessageResponse save(Lesson lesson) {
        // for student
        List<FreeTeachersTime> timeList = freeTeachersTimeService.getByTeacherDetailsAndDay(lesson.getTeacherDetail(),lesson.getDatelesson(),
                lesson.getTimelesson(),lesson.getTimeLessonEnd());
        System.out.println("SIZE   "+timeList.size());
        if (timeList.size()!=0){
            // free date
            List<Lesson> lessons = repository.getLessonByTeacherDetailAndAndTimelesson(lesson.getTeacherDetail(),lesson.getDatelesson(),lesson.getTimelesson(),lesson.getTimeLessonEnd());
            if(lessons.size()==0){
                // good time save
//                repository.save(lesson);
                String message = "Запит на провеення уроку із предмету "+ lesson.getSubject().getNamesubject()+ "\r\n" +
                        "  Cтудент "  + lesson.getStudentDetails().getUser().getUserName()+" \r\n  дата та час проведення "+ lesson.getDatelesson() +" "+ lesson.getTimelesson()+" "+
                        " Час завершення уроку "+ lesson.getTimeLessonEnd();

                SendEmail sendEmail = new SendEmail();
                sendEmail.sendEmail(lesson.getTeacherDetail().getUser().getEmail(),message);

                return new MessageResponse("Sended");
            }else {
                return new MessageResponse("This time is not free");
            }
        }else {
            return new MessageResponse("This date is not exit in teacher");
        }
//        repository.save(lesson);
    }

    @Override
    public Lesson getById(int id) {
        return repository.getOne(id);
    }

    @Override
    public List<Lesson> getAll() {
        return repository.findAll();
    }

    @Override
    public List<Lesson> getLessonByTeacherDetail(TeacherDetail detail) {
        return repository.getLessonByTeacherDetail(detail);
    }

    @Override
    public List<Lesson> getLessonByTeacherDetailAndAndTimelesson(TeacherDetail detail, Date date, Date times, Date timed) {
        return repository.getLessonByTeacherDetailAndAndTimelesson(detail,date,times,timed);
    }

    @Override
    public List<Lesson> getLessonByTeacherDetailAndStatus(TeacherDetail detail, boolean status) {
        return repository.getLessonByTeacherDetailAndStatus(detail, status);
    }

    @Override
    public MessageResponse update(Lesson lesson) {
        String status;
        SendEmail sendEmail = new SendEmail();
        String message = "Статиу вами створеного уроку  "+ lesson.getSubject().getNamesubject()+ "\r\n" +
                "  Викладач "  + lesson.getTeacherDetail().getUser().getUserName()+" \r\n  дата та час проведення "+ lesson.getDatelesson() +" "+ lesson.getTimelesson()+" "+
                " Час завершення уроку "+ lesson.getTimeLessonEnd()+" \r\n Статус ";
        if (lesson.isStatus()){
            status = "Прийнято ";
            repository.save(lesson);
            message = message+status;

            sendEmail.sendEmail(lesson.getStudentDetails().getUser().getEmail(),message);
            repository.save(lesson);
        }else {
            status = "Відхилено";
            message = message+status;
            sendEmail.sendEmail(lesson.getStudentDetails().getUser().getEmail(),message);
        repository.delete(lesson);// видалення якщо викладач відхилив запит
        }

        return new MessageResponse(status);
    }
}
