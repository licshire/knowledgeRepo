package com.zh.framework.service;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zh.framework.entity.ApprovalRecord;
import com.zh.framework.entity.Knowledge;
import com.zh.framework.entity.PageBean;
import com.zh.framework.mapper.KnowledgeMapper;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.transform.sax.SAXSource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service("knowledgeService")
//public class KnowldegeServiceImpl extends BaseServiceImpl<Knowledge> implements KnowledgeService{
public class KnowldegeServiceImpl implements KnowledgeService {
    @Autowired
    KnowledgeMapper knowledgeMapper;

    @Override
    public PageBean queryAllKnowledge(PageBean pageBean) {

        PageHelper.startPage(pageBean.getCurrentPage(), pageBean.getPageSize());

        List<Knowledge> list=knowledgeMapper.queryAllKnowledge();

        for (Knowledge aa:list){

            String uname=knowledgeMapper.queryUserNameById(aa.getCreateUserId());

            aa.setCreateUserId(uname);

            uname=knowledgeMapper.queryUserNameById(aa.getkApprUserId());

            aa.setkApprUserId(uname);

        }



        PageInfo<Knowledge> pageInfo = new PageInfo<Knowledge>(list);
        PageBean pb = new PageBean();
        pb.setSidx(pageBean.getSidx());
        pb .setSord(pageBean.getSord());
        pb.setTotalPages(pageInfo.getPages());
        pb.setPageSize(pageInfo.getPageSize());
        pb.setTotalCounts((int) pageInfo.getTotal());
        pb.setCurrentPage(pageInfo.getPageNum());
        pb.setContent(pageInfo.getList());
        return pb;
    }


    @Override
    public PageBean querySomeKnowledge(PageBean pageBean) {

//        ObjectMapper mapper = new ObjectMapper();
//        mapper.getSerializationConfig().setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

        PageHelper.startPage(pageBean.getCurrentPage(), pageBean.getPageSize());


        List<Knowledge> list=knowledgeMapper.querySomeKnowledge();

        for (Knowledge aa:list){

            String uname=knowledgeMapper.queryUserNameById(aa.getCreateUserId());

            aa.setCreateUserId(uname);

            uname=knowledgeMapper.queryUserNameById(aa.getkApprUserId());

            aa.setkApprUserId(uname);

        }


        PageInfo<Knowledge> pageInfo = new PageInfo<Knowledge>(list);
        PageBean pb = new PageBean();
        pb.setSidx(pageBean.getSidx());
        pb .setSord(pageBean.getSord());
        pb.setTotalPages(pageInfo.getPages());
        pb.setPageSize(pageInfo.getPageSize());
        pb.setTotalCounts((int) pageInfo.getTotal());
        pb.setCurrentPage(pageInfo.getPageNum());
        pb.setContent(pageInfo.getList());
        return pb;
    }

    @Override
    public PageBean queryKnowledgeOrder(PageBean pageBean) {

        PageHelper.startPage(pageBean.getCurrentPage(), pageBean.getPageSize());

        String aaa="使用次数=";
        List<Knowledge> list=knowledgeMapper.queryKnowledgeOrder(pageBean.getSidx(),pageBean.getSord());

        for (Knowledge aa:list){
            System.out.println("使用次数="+aa.getkUseCount());
            aaa=aaa+"#"+aa.getkUseCount();
            String uname=knowledgeMapper.queryUserNameById(aa.getCreateUserId());

            aa.setCreateUserId(uname);

            uname=knowledgeMapper.queryUserNameById(aa.getkApprUserId());

            aa.setkApprUserId(uname);

        }
        System.out.println(aaa);

        PageInfo<Knowledge> pageInfo = new PageInfo<Knowledge>(list);
        PageBean pb = new PageBean();
        pb.setSidx(pageBean.getSidx());
        pb .setSord(pageBean.getSord());
        pb.setTotalPages(pageInfo.getPages());
        pb.setPageSize(pageInfo.getPageSize());
        pb.setTotalCounts((int) pageInfo.getTotal());
        pb.setCurrentPage(pageInfo.getPageNum());
        pb.setContent(pageInfo.getList());
        return pb;

    }

    @Override
    public PageBean queryKnowledgeOrder2(PageBean pageBean) {

        PageHelper.startPage(pageBean.getCurrentPage(), pageBean.getPageSize());

        String aaa="使用次数=";
        List<Knowledge> list=knowledgeMapper.queryKnowledgeOrder2(pageBean.getSidx(),pageBean.getSord());

        for (Knowledge aa:list){
            System.out.println("使用次数="+aa.getkUseCount());
            aaa=aaa+"#"+aa.getkUseCount();
            String uname=knowledgeMapper.queryUserNameById(aa.getCreateUserId());

            aa.setCreateUserId(uname);

            uname=knowledgeMapper.queryUserNameById(aa.getkApprUserId());

            aa.setkApprUserId(uname);

        }
        System.out.println(aaa);

        PageInfo<Knowledge> pageInfo = new PageInfo<Knowledge>(list);
        PageBean pb = new PageBean();
        pb.setSidx(pageBean.getSidx());
        pb .setSord(pageBean.getSord());
        pb.setTotalPages(pageInfo.getPages());
        pb.setPageSize(pageInfo.getPageSize());
        pb.setTotalCounts((int) pageInfo.getTotal());
        pb.setCurrentPage(pageInfo.getPageNum());
        pb.setContent(pageInfo.getList());
        return pb;

    }

    @Override
    public void addKnowledge(Knowledge k) {
        knowledgeMapper.addKnowledge(k);

    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public void deleteKnowledge(String id) {
        knowledgeMapper.deleteKnowledge(id);

    }

    @Override
    public void updateKnowledge(String id,String kTitle,String createUserId,String kAnswer){
        knowledgeMapper.updateKnowledge(id,kTitle,createUserId,kAnswer);
    }

    @Override
    public void updateKnowledgeStatus(String id, String status) {
        knowledgeMapper.updateKnowledgeStatus(id,status);

    }

    @Override
    public Knowledge queryKnowledgeById(String id) {
        return knowledgeMapper.queryKnowledgeById(id);
    }

    @Override
    public void updateAppr(String id, String kApprUserId, String kApprMemo, Date kApprTime) {
        knowledgeMapper.updateAppr(id, kApprUserId, kApprMemo, kApprTime);
    }


    @Override
    public PageBean search(String searchKey,String keyValue,PageBean pageBean) {



        PageHelper.startPage(pageBean.getCurrentPage(), pageBean.getPageSize());

        List<Knowledge> list=knowledgeMapper.search(searchKey,keyValue);

        for (Knowledge aa:list){
            String uname=knowledgeMapper.queryUserNameById(aa.getCreateUserId());

            aa.setCreateUserId(uname);

            uname=knowledgeMapper.queryUserNameById(aa.getkApprUserId());

            aa.setkApprUserId(uname);

        }


        PageInfo<Knowledge> pageInfo = new PageInfo<Knowledge>(list);
        PageBean pb = new PageBean();
        pb.setSidx(pageBean.getSidx());
        pb .setSord(pageBean.getSord());
        pb.setTotalPages(pageInfo.getPages());
        pb.setPageSize(pageInfo.getPageSize());
        pb.setTotalCounts((int) pageInfo.getTotal());
        pb.setCurrentPage(pageInfo.getPageNum());
        pb.setContent(pageInfo.getList());
        return pb;

    }

    public List<Knowledge> queryByKtitle(String kTitle){

        return knowledgeMapper.queryByKtitle(kTitle);

    }



    @Override
    public List<ApprovalRecord> queryAppar(String kid) {
        return knowledgeMapper.queryAppr(kid);
    }

    @Override
    public void addAppar(ApprovalRecord approvalRecord) {
        knowledgeMapper.addAppr(approvalRecord.getId(),approvalRecord.getKid(), approvalRecord.getaTime(),approvalRecord.getbStatus(), approvalRecord.getaStatus(),approvalRecord.getDs());
    }
}
