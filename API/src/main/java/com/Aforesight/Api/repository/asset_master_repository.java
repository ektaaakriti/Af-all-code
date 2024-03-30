package com.Aforesight.Api.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.Aforesight.Api.entity.asset_master;
import com.Aforesight.Api.entity.vf_assets;
import com.Aforesight.Api.response.LocationResponse;
@Repository
public interface asset_master_repository<S> extends JpaRepository<asset_master, Long> {
	 //@Autowired Asset_master_repo_impl assrepo;
	   public static final EntityManager entityManager = null;

       // peticiones = (List<asset_master>) em.createQuery(consulta).getResultList();
        //return consulta;
    

	//String query=findByFilter1(@Param ("System_Serial_Number") String System_Serial_Number,@Param("System_Make") String System_Make, @Param("System_Model") String System_Model, @Param("Product_Type") String Product_Type,@ Param("System_OS_type") String System_OS_type);
	@Query("SELECT a FROM asset_master a  WHERE(:System_Serial_Number is null or a.System_Serial_Number=:System_Serial_Number) "
			+ "and (:System_Make is null or a.System_Make =:System_Make) and (:System_Model is null or a.System_Model=:System_Model) and (:Product_Type is null or a.Product_Type=:Product_Type) and "
			+ "(:System_OS_type is null or a.System_OS_type=:System_OS_type)")
	List<asset_master> findAsset(@Param ("System_Serial_Number") String System_Serial_Number,@Param("System_Make") String System_Make, @Param("System_Model") String System_Model, @Param("Product_Type") String Product_Type,@ Param("System_OS_type") String System_OS_type) ;
	
	@Transactional
	 @Modifying(clearAutomatically = true) 
	@Query("update asset_master a set a.Delete_status=?1 where a.asset_id=?2" )
	public void deleteAsset(String delete_status,Long asset_id);
	 
	@Query("select a from asset_master a where a.asset_id=?1 and a.Delete_status='NO'")
	List<asset_master> assetToUpdate(Long asset_id);
	/*@Transactional
	 @Modifying(clearAutomatically = true)
	@Query("update asset_master a set a.Scan_Date=?1, a.System_Make=?2, a.System_Model=?3,a.Product_Type=?4,a.System_IP_Address=?5, a.System_Hostname=?6,a.System_OS_type=?7,a.OS_Version=?8,a.Total_RAM=?9, a.RAM_Available=?10,a.RAM_Used=?11, a.HD_Make=?12,a.HD_Model=?13,a.HD_Serial_Number=?14,a.HD_Capacity=?15,a.Processor_Details=?16,a.MBD_Make=?17,a.MBD_Model=?18,a.MBD_Serial_Number=?19, a.Type_of_Chipset=?20, a.Monitor_Screen_Make=?21,a.Monitor_Model=?22, a.Monitor_Serial_Number=?23,a.Monitor_Screen_Size=?24,a.Assets_Status=?25,"
			+ "a.Retired_Date=?26,a.Software_list_with_version_and_installed_Date=?27, a.Procured_Date=?28, a.Procument_ID=?29, a.Warranty_AMC=?30, a.Warranty_AMC_Vendor_Name=?31, a.Warrenty_AMC_From=?32,  a.Warrenty_AMC_To=?33,a.username=?34,a.Department_Name=?35, a.Site_Name=?36,a.Sub_Department_Name=?37, a.Aforesight_Agent_ID=?38,a.System_Serial_Number=?39,a.MS_Office_2010=?40,a.MS_Office_2013=?41, a.MS_Office_2016=?42, a.Adobe_Reader=?43, a.Java8=?44, a.Symantec_Antivirus=?45, a.Mcafee_Antivirus=?46, a.Trend_Micro_Antivirus=?47, a.Microsoft_Teams=?48, a.MS_Office_2007=?49, a.Anydesk=?50, a.OneDrive=?51, a.zip7=?52, a.Mozilla_Firefox=?53, a.Google_Chrome=?54,a.Team_Viewer=?55, a.Zoom=?56, a.Webex=?57, a.AutoCad=?58, a.Winrar=?59 where a.asset_id=?60")
	public void updateAsset(String Scan_Date, String System_Make,String System_Model, String Product_Type, String System_IP_Address, String System_Hostname, String System_OS_type, String OS_Version, String Total_RAM,String RAM_Available, String RAM_Used, String HD_Make, String HD_Model, String HD_Serial_Number, String HD_Capacity, String Processor_Details, String MBD_Make, String MBD_Model, String MBD_Serial_Number, String Type_of_Chipset, String Monitor_Screen_Make,String Monitor_Model, String Monitor_Serial_Number, String Monitor_Screen_Size, String Assets_Status, String Retired_Date,String Software_list_with_version_and_installed_Date, String Procured_Date, String Procument_ID, String Warranty_AMC, String Warranty_AMC_Vendor_Name, String Warrenty_AMC_From, String Warrenty_AMC_To, String User_ID, String Department_Name, String Site_Name, String Sub_Department_Name,String Aforesight_Agent_ID, String System_Serial_Number,String  MS_Office_2010,String MS_Office_2013, String MS_Office_2016, String Adobe_Reader, String  Java8,String Symantec_Antivirus, String Mcafee_Antivirus, String  Trend_Micro_Antivirus,String Microsoft_Teams,String  MS_Office_2007, String Anydesk,String OneDrive,String zip7, String  Mozilla_Firefox, String  Google_Chrome, String  Team_Viewer,String Zoom,String Webex,String AutoCad,String Winrar,long asset_id);*/
	@Transactional
	 @Modifying(clearAutomatically = true)
	@Query("update asset_master a set a.Scan_Date=?1, a.System_Make=?2, a.System_Model=?3,a.Product_Type=?4,a.System_IP_Address=?5, a.System_Hostname=?6,a.System_OS_type=?7,a.OS_Version=?8,a.Total_RAM=?9, a.RAM_Available=?10,a.RAM_Used=?11, a.HD_Make=?12,a.HD_Model=?13,a.HD_Serial_Number=?14,a.HD_Capacity=?15,a.Processor_Details=?16,a.MBD_Make=?17,a.MBD_Model=?18,a.MBD_Serial_Number=?19, a.Type_of_Chipset=?20, a.Monitor_Screen_Make=?21,a.Monitor_Model=?22, a.Monitor_Serial_Number=?23,a.Monitor_Screen_Size=?24,a.Assets_Status=?25,"
			+ "a.Retired_Date=?26,a.Software_list_with_version_and_installed_Date=?27, a.Procured_Date=?28, a.Procument_ID=?29, a.Warranty_AMC=?30, a.Warranty_AMC_Vendor_Name=?31, a.Warrenty_AMC_From=?32,  a.Warrenty_AMC_To=?33,a.username=?34,a.Department_Name=?35, a.Site_Name=?36,a.Sub_Department_Name=?37, a.Aforesight_Agent_ID=?38,a.System_Serial_Number=?39 where a.asset_id=?40")
	public void updateAsset(String Scan_Date, String System_Make,String System_Model, String Product_Type, String System_IP_Address, String System_Hostname, String System_OS_type, String OS_Version, String Total_RAM,String RAM_Available, String RAM_Used, String HD_Make, String HD_Model, String HD_Serial_Number, String HD_Capacity, String Processor_Details, String MBD_Make, String MBD_Model, String MBD_Serial_Number, String Type_of_Chipset, String Monitor_Screen_Make,String Monitor_Model, String Monitor_Serial_Number, String Monitor_Screen_Size, String Assets_Status, String Retired_Date,String Software_list_with_version_and_installed_Date, String Procured_Date, String Procument_ID, String Warranty_AMC, String Warranty_AMC_Vendor_Name, String Warrenty_AMC_From, String Warrenty_AMC_To, String User_ID, String Department_Name, String Site_Name, String Sub_Department_Name,String Aforesight_Agent_ID, String System_Serial_Number,long asset_id);
	@Query("select distinct a.System_Serial_Number from asset_master a")
	List findsystemserialnumber();
	@Query("select distinct a.asset_id from asset_master a")
	List asset_id();
	@Query("select distinct a.System_Make from asset_master a")
	List findSystem_Make();
	@Query("select distinct a.Product_Type from asset_master a")
	List findProduct_Type();
	@Query("select distinct a.System_Model from asset_master a")
	List findSystem_Model();
	@Query("select distinct a.System_OS_type from asset_master a")
	List findSystem_OS_type();
    @Query("select distinct a.asset_id, a.System_Serial_Number,a.Product_Type,a.System_IP_Address,a.System_Model from asset_master a")
    List findassetdetails();
    @Transactional
	 @Modifying(clearAutomatically = true) 
	@Query("update asset_master a SET a.Assets_Status=?1,a.Retired_Date=?2 WHERE a.asset_id=?3 ")
	void retirestatus(String Assets_Status,String Retired_Date,Long asset_id);
    @Transactional
	 @Modifying(clearAutomatically = true) 
	@Query("update asset_master a SET a.Assets_Status=?1,a.Site_Name=?2,a.Department_Name=?3 WHERE a.asset_id=?4 ")
	void allocateAsset(String Assets_Status,String Site_Name, String Department_Name,Long asset_id);
    @Transactional
	 @Modifying(clearAutomatically = true) 
	@Query("update asset_master a SET a.Assets_Status=?1 , a.Department_Name=?3 where a.asset_id=?2 ")
	void deallocateAsset(String Assets_Status,Long asset_id,String Department_Name);
    @Query("select distinct a.Site_Name from asset_master a")
   List findlocation();
    @Query("select distinct a.Department_Name from asset_master a")
    List finddepartment();
    @Query("select a from asset_master a")
    List<asset_master> full_asset_table();
    @Query("select a from asset_master a order by a.Department_Name ")
    List<asset_master> Asset_report_departmentwise();
    @Query("select a from asset_master a order by a.Site_Name ")
    List<asset_master> Asset_report_Site_Name();
   @Query(" select a.Department_Name as Department_Name, count(a.Department_Name)  from asset_master a group by a.Department_Name ")
   List<Tuple> department_count();
   @Query(" select a.Assets_Status as Assets_Status, count(a.Assets_Status)  from asset_master a group by a.Assets_Status ")
   List<Tuple> status_count();
   @Query("  SELECT COUNT(*) FROM asset_master a")
   Long asset_count();
   @Query("SELECT a.Product_Type as Product, COUNT(*) as count FROM asset_master a GROUP BY a.Product_Type")
   List<Tuple> product_type_count();
   @Query(value="SELECT a.Site_Name as state, COUNT(*) as count FROM asset_master a GROUP BY a.Site_Name",nativeQuery=true)
   List <Tuple> Location_count();
   @Query("select(select count(a.Adobe_Reader) from asset_master a where a.Adobe_Reader='YES')as Adobe_Reader,"
   		+ "(select count(a.Java8) from asset_master a where a.Java8='YES')as Java8,"
   		+ "(select count(a.Google_Chrome) from asset_master a where a.Google_Chrome='YES')as Google_Chrome,"
   		+ "(select count(a.Winrar) from asset_master a where a.Winrar='YES')as Winrar,"
   		+ "(select count(a.AutoCad) from asset_master a where a.AutoCad='YES')as AutoCad,"
   		+ "(select count(a.Webex) from asset_master a where a.Webex='YES')as Webex,"
   		+ "(select count(a.Zoom) from asset_master a where a.Zoom='YES')as Zoom,"
   		+ "(select count(a.Team_Viewer) from asset_master a where a.Team_Viewer='YES')as Team_Viewer,"
   		+ "(select count(a.Mozilla_Firefox) from asset_master a where a.Mozilla_Firefox='YES')as Mozilla_Firefox,"
   		+ "(select count(a.zip7) from asset_master a where a.zip7='YES') as zip7,"
   		+ "(select count(a.OneDrive) from asset_master a where a.OneDrive='YES')as OneDrive,"
   		+ "(select count(a.Anydesk) from asset_master a where a.Anydesk='YES')as Anydesk,"
   		+ "(select count(a.MS_Office_2007) from asset_master a where a.MS_Office_2007='YES')as MS_Office_2007,"
   		+ "(select count(a.Microsoft_Teams) from asset_master a where a.Microsoft_Teams='YES')as Microsoft_Teams,"
   		+ "(select count(a.Trend_Micro_Antivirus) from asset_master a where a.Trend_Micro_Antivirus='YES')as Trend_Micro_Antivirus,"
   		+ "(select count(a.Mcafee_Antivirus) from asset_master a where a.Mcafee_Antivirus='YES')as Mcafee_Antivirus,"
   		+ "(select count(a.Symantec_Antivirus) from asset_master a where a.Symantec_Antivirus='YES')as Symantec_Antivirus,"
   		+ "(select count(a.MS_Office_2016) from asset_master a where a.MS_Office_2016='YES')as MS_Office_2016,"
   		+ "(select count(a.MS_Office_2010) from asset_master a where a.MS_Office_2010='YES')as MS_Office_2010,"
   		+ "(select count(a.MS_Office_2013) from asset_master a where a.MS_Office_2013='YES')as MS_Office_2013"
   		+ " from asset_master a")
   List<Tuple> softwareCount_dashboard();
   @Query("select count(a.MS_Office_2010) from asset_master a where a.MS_Office_2010='YES'")
   String office10Count();
   @Query("select count(a.MS_Office_2013) from asset_master a where a.MS_Office_2013='YES'")
   String office13Count();
   
   @Query("select count(a.Mozilla_Firefox) from asset_master a where a.Mozilla_Firefox='YES'")
   String mozilla_count();
   @Query("select count(a.OneDrive) from asset_master a where a.OneDrive='YES'")
   String oneDrive_Count();
   @Query("select count(a.Anydesk) from asset_master a where a.Anydesk='YES'")
   String AnydeskCount();
   @Query("select count(a.MS_Office_2007) from asset_master a where a.MS_Office_2007='YES'")
   String offive7_count();
   @Query("select count(a.Microsoft_Teams) from asset_master a where a.Microsoft_Teams='YES'")
   String teams_count();
   @Query("select count(a.Trend_Micro_Antivirus) from asset_master a where a.Trend_Micro_Antivirus='YES'")
   String TrendAntivirusCount();
   @Query("select count(a.Mcafee_Antivirus) from asset_master a where a.Mcafee_Antivirus='YES'")
   String Mcafee_count();
   @Query("select count(a.Symantec_Antivirus) from asset_master a where a.Symantec_Antivirus='YES'")
   String SymantecCount();
   @Query("select count(a.MS_Office_2016) from asset_master a where a.MS_Office_2016='YES'")
   String office16Count();
   
   @Query("select count(a.Team_Viewer) from asset_master a where a.Team_Viewer='YES'")
   String Team_viewerCount();
   @Query("select count(a.Zoom) from asset_master a where a.Zoom='YES'")
   String Zoom_Count();
   @Query("select count(a.Webex) from asset_master a where a.Webex='YES'")
   String webex();
   @Query("select count(a.Adobe_Reader) from asset_master a where a.Adobe_Reader='YES'")
   String adobe_count();
   @Query("select count(a.Java8) from asset_master a where a.Java8='YES'")
   String java_count();
   @Query("select count(a.Google_Chrome) from asset_master a where a.Google_Chrome='YES'")
   String google_count();
   @Query("select count(a.Winrar) from asset_master a where a.Winrar='YES'")
   String winrar_count();
   @Query("select count(a.AutoCad) from asset_master a where a.AutoCad='YES'")
   String Autocad_count();
   
   
   //EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence.xml");
  // @PersistenceContext
  // EntityManager em=entityManagerFactory.createEntityManager();
  
// List<asset_master> findAsset1( String System_Serial_Number,String System_Make, String System_Model, String Product_Type, String System_OS_type) ;
	
  
	  /* CriteriaBuilder cb = em.getCriteriaBuilder();
       CriteriaQuery<asset_master> cq = cb.createQuery(asset_master.class);

       Root<asset_master> ast = cq.from(asset_master.class);
       Predicate systemName = cb.equal(ast.get("System_Serial_Number"), System_Serial_Number);
       Predicate SystemMake = cb.equal(ast.get("System_Make"), System_Make);
       Predicate SystemModel=cb.equal(ast.get("System_Model"), System_Model);
       Predicate ProductType=cb.equal(ast.get("Product_Type"), Product_Type);
       Predicate SystemOStype=cb.equal(ast.get("System_OS_type"),System_OS_type);
       cq.where(systemName,SystemMake,SystemModel,ProductType,SystemOStype);

       TypedQuery<asset_master> query = em.createQuery(cq);
       return query.getResultList();
   }*/
}
