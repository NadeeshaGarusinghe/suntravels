package com.Codegen.suntravels.services;

import com.Codegen.suntravels.dao.ContractDao;
import com.Codegen.suntravels.dto.ContractResponse;
import com.Codegen.suntravels.dto.MarkedupContractResponse;
import com.Codegen.suntravels.dto.ViewContractHotelResponse;
import com.Codegen.suntravels.dto.ViewContractRoomTypeRespose;
import com.Codegen.suntravels.model.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
@Service
public class QueryService implements IQueryService{
    @Autowired
    ContractDao contractDao;

    @Autowired
    EntityManagerFactory emf;
    @SuppressWarnings("unchecked")
    @Override
    public List<ViewContractHotelResponse> HotelContractExplicitJoin() {
        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();
        List<ViewContractHotelResponse> results=em.createQuery("SELECT c.cid,c.startdate,c.enddate,c.markup,h.name,h.locationid,h.phone " +
                "FROM Contract c JOIN Hotel h " +
                "ON c.hid=h.hid ").getResultList();
        System.out.println("Contract Name: ");
        em.getTransaction().commit();
        em.close();
        return results;
    }

    @Override
    public List<ViewContractRoomTypeRespose> ContractRoomTypeImplicitJoin() {
        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();
        List<ViewContractRoomTypeRespose> results=em.createQuery("SELECT new com.Codegen.suntravels.dto.ViewContractRoomTypeRespose(c.cid,c.markup,c.startdate,c.enddate, r.rprice,r.maxadults,r.availablerooms) FROM Contract c JOIN c.roomDetails r").getResultList();
        em.getTransaction().commit();
        em.close();
        return results;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<MarkedupContractResponse> CHCRExplicitJoin(Date checkindate, int noofnights, int noofroomswithadults) {
      Calendar c=Calendar.getInstance();
      c.setTime(checkindate);
      c.add(Calendar.DATE,noofnights);
      Date finalday=c.getTime();

        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();
        List<ContractResponse> results=em.createQuery("SELECT new com.Codegen.suntravels.dto.ContractResponse(c.cid,c.markup,c.startdate,c.enddate, r.rprice,r.maxadults,r.availablerooms,r.rtypeid,h.name,h.phone,h.location,t.roomtype) FROM Contract c JOIN c.roomDetails r JOIN Hotel h ON c.hid=h.hid JOIN RoomType t ON t.rtypeid=r.rtypeid WHERE c.startdate<=?1 AND c.enddate>=?2").setParameter(1,checkindate).setParameter(2,finalday).getResultList();
        em.getTransaction().commit();
        em.close();
        return this.getMarkedupResponse(results,noofnights,noofroomswithadults);

        //return results;
    }


    public List<MarkedupContractResponse> getMarkedupResponse(List<ContractResponse> list,int noofnights,int noofroomswithadults){
        List<MarkedupContractResponse> result=new ArrayList<MarkedupContractResponse>();

        for (ContractResponse m:list){
            MarkedupContractResponse temp=new MarkedupContractResponse();
            String name=m.getName();
            String rtype=m.getRoomtype();
            double markedupprice=((m.getMarkup()+100)/100)*m.getRprice()*noofnights*noofroomswithadults;
            if (m.getMaxadults()>=noofroomswithadults){
                temp.setAvailabilitystatus(true);
            }
            else {
                temp.setAvailabilitystatus(false);
            }
            temp.setMarkedupprice(markedupprice);
            temp.setName(name);
            temp.setRoomtype(rtype);
            System.out.println(temp.getMarkedupprice());
            System.out.println(temp.getName());
            System.out.println(noofnights);
            System.out.println(noofroomswithadults);

            result.add(temp);
            System.out.println(result);
        }
        return result;
    }




    public List<Contract> contractAllData(){
        return contractDao.findAll();
    }
    public void newQuery(){

    }
}
