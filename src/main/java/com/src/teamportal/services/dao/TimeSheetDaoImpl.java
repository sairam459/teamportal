package com.src.teamportal.services.dao;

import com.src.teamportal.application.model.WeekRecordRequest;
import com.src.teamportal.core.entity.TimeSheet;
import com.src.teamportal.core.repository.TimeSheetDao;
import com.src.teamportal.utils.GeneralUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;


@Component
public class TimeSheetDaoImpl implements TimeSheetDao {
    @Autowired
    private MongoOperations mongoOperations;

    @Autowired
    private GeneralUtils generalUtils;



    public void createRecord(TimeSheet t){
//        String pattern = "MM-dd-yyyy";
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
//        t.setWork_date((Date) simpleDateFormat.format(t.getWork_date()));
        mongoOperations.save(t);
    }

    public TimeSheet getRecord(String id){
        return mongoOperations.findOne(query(where("_id").is(id)),TimeSheet.class);
    }

   public void updateRecord(String id, Map t){

        TimeSheet h=mongoOperations.findById(id,TimeSheet.class);

        try {
            TimeSheet ti=(TimeSheet) generalUtils.commonUpdate(t,h);

            createRecord(ti);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void clearRecord(String id,TimeSheet t){
        System.out.println("gg");
        Query query = new Query();
        query.addCriteria(where("emp_id").is(id).and("_id").is(t.getId()));

        mongoOperations.remove(query,TimeSheet.class);
    }

    public List<TimeSheet> fetchWeekRecord(String eid, WeekRecordRequest interval){
         Query query = new Query();
        query.addCriteria(where("emp_id").is(eid).andOperator(Criteria.where("work_date").gte(interval.getFrom_date()),Criteria.where("work_date").lte(interval.getTo_date())));
       // query.addCriteria(where("emp_id").is(eid).and("work_date").lte(interval.get("from")));
        List<TimeSheet> l=mongoOperations.find(query,TimeSheet.class);
        return l;
    }

    public List<TimeSheet> getAllRecords(String eid){
        Query query = new Query();
        query.addCriteria(where("emp_id").is(eid));
        List<TimeSheet> l=mongoOperations.find(query,TimeSheet.class);
        return l;
    }
}
