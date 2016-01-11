$(document).ready(function(){  
empProfile={		    		    
       taskmenu:function(clickid)
			{
    	   if(clickid=="employeeDetails"){
    		   var taskbarItems=['Home','Basic Profile','Professional','Family','Education','Documents','Reset Password']
    		   var taskbarLinkPages=['HomeWidgets',"employeeDetails", "professionalInfo","familyInfo","employeeEducationDetails","download","ResetPassword"]
    		   $( ".taskbar-row" ).empty();
    		   
    		   MasterJs.addTaskbar(7, taskbarItems, 'menu',taskbarLinkPages);
    		   
    		   document.getElementById('employeeDetails').classList.add('taskbar-celladd');
      	 }
    	   else if(clickid=="HomeWidgets"){
    		   var taskbarItems=['Home','Basic Profile','Professional','Family','Education','Documents','Reset Password']
    		   var taskbarLinkPages=['HomeWidgets',"employeeDetails", "professionalInfo","familyInfo","employeeEducationDetails","download","ResetPassword"]
    		   $( ".taskbar-row" ).empty();
    		   MasterJs.addTaskbar(7, taskbarItems, 'menu',taskbarLinkPages);
    		   document.getElementById('HomeWidgets').classList.add('taskbar-celladd');
    		   
       	 	}
    	   else if(clickid=="download"){
    		   var taskbarItems=['Home','Basic Profile','Professional','Family','Education','Documents','Reset Password']
    		   var taskbarLinkPages=['HomeWidgets',"employeeDetails", "professionalInfo","familyInfo","employeeEducationDetails","download","ResetPassword"]
    		   $( ".taskbar-row" ).empty();
    		   MasterJs.addTaskbar(7, taskbarItems, 'menu',taskbarLinkPages);
    		   document.getElementById('EmployeeDocuments').classList.add('taskbar-celladd');
         	 	}
      	 else if(clickid=="familyInfo"){
      		 var taskbarItems=['Home','Basic Profile','Professional','Family','Education','Documents','Reset Password']
      		 var taskbarLinkPages=['HomeWidgets',"employeeDetails", "professionalInfo","familyInfo","employeeEducationDetails","download","ResetPassword"]
      		 $( ".taskbar-row" ).empty();
      		 MasterJs.addTaskbar(7, taskbarItems, 'menu',taskbarLinkPages);
      	   document.getElementById('familyInfo').classList.add('taskbar-celladd');
      		 
       	 	}
      	 else if(clickid=="professionalInfo"){
      		 var taskbarItems=['Home','Basic Profile','Professional','Family','Education','Documents','Reset Password']
      		 var taskbarLinkPages=['HomeWidgets',"employeeDetails", "professionalInfo","familyInfo","employeeEducationDetails","download","ResetPassword"]
      		 $( ".taskbar-row" ).empty();
      		 MasterJs.addTaskbar(7, taskbarItems, 'menu',taskbarLinkPages);
      		  document.getElementById('professionalInfo').classList.add('taskbar-celladd');
       	 	}
      	else if(clickid=="employeeEducationDetails"){
      		var taskbarItems=['Home','Basic Profile','Professional','Family','Education','Documents','Reset Password']
      		var taskbarLinkPages=['HomeWidgets',"employeeDetails", "professionalInfo","familyInfo","employeeEducationDetails","download","ResetPassword"]
      		$( ".taskbar-row" ).empty();
      		MasterJs.addTaskbar(7, taskbarItems, 'menu',taskbarLinkPages);
      	  document.getElementById('employeeEducationDetails').classList.add('taskbar-celladd');
      	 	}
    	
      	 else if(clickid=="employeeList"){
      		 var taskbarItems=['Home','Employee List','Register']
    	   		 var taskbarLinkPages=['HomeWidgets',"employeeList", "empRegister.jsp"]
      		 $( ".taskbar-row" ).empty();
    	   		MasterJs.addTaskbar(3, taskbarItems, 'menu',taskbarLinkPages);
    	   		document.getElementById('employeeList').classList.add('taskbar-celladd');
      	 }
        	 else if(clickid=="empRegister"){
      		 var taskbarItems=['Home','Employee List','Register']
    	   		 var taskbarLinkPages=['HomeWidgets',"employeeList", "empRegister.jsp"]
      		 $( ".taskbar-row" ).empty();
    	   		MasterJs.addTaskbar(3, taskbarItems, 'menu',taskbarLinkPages);
    	   		document.getElementById('empRegister').classList.add('taskbar-celladd');
      	 }
        	else if(clickid=="leaveViewAction"){
     		 var taskbarItems=['Home','Summary','Details','Application']
   	   		 var taskbarLinkPages=['HomeWidgets',"leaveViewAction","leaveHistoryViewAction", "employeeLeaveApply"]
     		 	$( ".taskbar-row" ).empty();
   	   		MasterJs.addTaskbar(4, taskbarItems, 'menu',taskbarLinkPages);
   	   	document.getElementById('leaveViewAction').classList.add('taskbar-celladd');
        	}
        	else if(clickid=="employeeLeaveApply"){
        		 var taskbarItems=['Home','Summary','Details','Application']
   	   		 var taskbarLinkPages=['HomeWidgets',"leaveViewAction","leaveHistoryViewAction", "employeeLeaveApply"]
        		 $( ".taskbar-row" ).empty();
      	   		MasterJs.addTaskbar(4, taskbarItems, 'menu',taskbarLinkPages);
      	    	document.getElementById('employeeLeaveApply').classList.add('taskbar-celladd');
        	 	}
        	else if(clickid=="leaveHistoryViewAction"){
       		 var taskbarItems=['Home','Summary','Details','Application']
  	   		 var taskbarLinkPages=['HomeWidgets',"leaveViewAction","leaveHistoryViewAction", "employeeLeaveApply"]
       		 $( ".taskbar-row" ).empty();
     	   		MasterJs.addTaskbar(4, taskbarItems, 'menu',taskbarLinkPages);
     	   	document.getElementById('leaveHistoryViewAction').classList.add('taskbar-celladd');
       	 	}
    	   
        	else if(clickid=="EmployeeTimeSheet"){
       		 var taskbarItems=['Home','TimeSheet Fill','TimeSheet Details']
  	   		 var taskbarLinkPages=['HomeWidgets',"EmployeeTimeSheet","empViewTimeSheet"]
       		 $( ".taskbar-row" ).empty();
     	   		MasterJs.addTaskbar(3, taskbarItems, 'menu',taskbarLinkPages);
     	   	document.getElementById('EmployeeTimeSheet').classList.add('taskbar-celladd');
       	 	}
        	else if(clickid=="empViewTimeSheet"){
          		 var taskbarItems=['Home','TimeSheet Fill','TimeSheet Details']
     	   		 var taskbarLinkPages=['HomeWidgets',"EmployeeTimeSheet","empViewTimeSheet"]
          		 $( ".taskbar-row" ).empty();
        	   		MasterJs.addTaskbar(3, taskbarItems, 'menu',taskbarLinkPages);
        	   		document.getElementById('empViewTimeSheet').classList.add('taskbar-celladd');
          	 	}
    	   
    	   
    	   
    	   
    	   
         	else if(clickid=="EmployeeHRPolicies"){
         		 var taskbarItems=['Home','Attendance','Leave Policy','Laptop Policy','Job Family','Performance','Domestic Travel','Bring A Buddy','Foreign Travel','Guest House','holiday List','I Card','Separation']
   	   		   var taskbarLinkPages=['HomeWidgets',"EmployeeHRPolicies","LeavePolicy","LaptopPolicy","JobFamily","PerformanceAppraisals","DomesticTravel","BringABuddy","ForeignTravelPolicy","GuestHousePolicy","holidaylist","ICardPolicy","SEPARATIONPOLICY"]
   		      $( ".taskbar-row" ).empty();
     	   		MasterJs.addTaskbar(13, taskbarItems, 'menu',taskbarLinkPages);
     	   	document.getElementById('EmployeeHRPolicies').classList.add('taskbar-celladd');
       	 	}
         	else if(clickid=="LeavePolicy"){
         		 var taskbarItems=['Home','Attendance','Leave Policy','Laptop Policy','Job Family','Performance','Domestic Travel','Bring A Buddy','Foreign Travel','Guest House','holiday List','I Card','Separation']
   	   		   var taskbarLinkPages=['HomeWidgets',"EmployeeHRPolicies","LeavePolicy","LaptopPolicy","JobFamily","PerformanceAppraisals","DomesticTravel","BringABuddy","ForeignTravelPolicy","GuestHousePolicy","holidaylist","ICardPolicy","SEPARATIONPOLICY"]
   		      $( ".taskbar-row" ).empty();
       	   		MasterJs.addTaskbar(13, taskbarItems, 'menu',taskbarLinkPages);
       	   	document.getElementById('LeavePolicy').classList.add('taskbar-celladd');
         	 	}
        
         	else if(clickid=="JobFamily"){
         		 var taskbarItems=['Home','Attendance','Leave Policy','Laptop Policy','Job Family','Performance','Domestic Travel','Bring A Buddy','Foreign Travel','Guest House','holiday List','I Card','Separation']
   	   		   var taskbarLinkPages=['HomeWidgets',"EmployeeHRPolicies","LeavePolicy","LaptopPolicy","JobFamily","PerformanceAppraisals","DomesticTravel","BringABuddy","ForeignTravelPolicy","GuestHousePolicy","holidaylist","ICardPolicy","SEPARATIONPOLICY"]
   		         $( ".taskbar-row" ).empty();
     	   		MasterJs.addTaskbar(13, taskbarItems, 'menu',taskbarLinkPages);
     	   	document.getElementById('JobFamily').classList.add('taskbar-celladd');
       	 	}
        	else if(clickid=="PerformanceAppraisals"){
        		 var taskbarItems=['Home','Attendance','Leave Policy','Laptop Policy','Job Family','Performance','Domestic Travel','Bring A Buddy','Foreign Travel','Guest House','holiday List','I Card','Separation']
   	   		   var taskbarLinkPages=['HomeWidgets',"EmployeeHRPolicies","LeavePolicy","LaptopPolicy","JobFamily","PerformanceAppraisals","DomesticTravel","BringABuddy","ForeignTravelPolicy","GuestHousePolicy","holidaylist","ICardPolicy","SEPARATIONPOLICY"]
   		    $( ".taskbar-row" ).empty();
        	   		MasterJs.addTaskbar(13, taskbarItems, 'menu',taskbarLinkPages);
        	   		document.getElementById('PerformanceAppraisals').classList.add('taskbar-celladd');
          	 	}
        	else if(clickid=="LaptopPolicy"){
        		 var taskbarItems=['Home','Attendance','Leave Policy','Laptop Policy','Job Family','Performance','Domestic Travel','Bring A Buddy','Foreign Travel','Guest House','holiday List','I Card','Separation']
   	   		   var taskbarLinkPages=['HomeWidgets',"EmployeeHRPolicies","LeavePolicy","LaptopPolicy","JobFamily","PerformanceAppraisals","DomesticTravel","BringABuddy","ForeignTravelPolicy","GuestHousePolicy","holidaylist","ICardPolicy","SEPARATIONPOLICY"]
   		     $( ".taskbar-row" ).empty();
    	   		MasterJs.addTaskbar(13, taskbarItems, 'menu',taskbarLinkPages);
    	 		document.getElementById('LaptopPolicy').classList.add('taskbar-celladd');
      	 	}
        	else if(clickid=="PerformanceAppraisals"){
        		 var taskbarItems=['Home','Attendance','Leave Policy','Laptop Policy','Job Family','Performance','Domestic Travel','Bring A Buddy','Foreign Travel','Guest House','holiday List','I Card','Separation']
   	   		   var taskbarLinkPages=['HomeWidgets',"EmployeeHRPolicies","LeavePolicy","LaptopPolicy","JobFamily","PerformanceAppraisals","DomesticTravel","BringABuddy","ForeignTravelPolicy","GuestHousePolicy","holidaylist","ICardPolicy","SEPARATIONPOLICY"]
   		     $( ".taskbar-row" ).empty();
 	   		MasterJs.addTaskbar(13, taskbarItems, 'menu',taskbarLinkPages);
 	   	document.getElementById('PerformanceAppraisals').classList.add('taskbar-celladd');
   	 	}
        	else if(clickid=="DomesticTravel"){
        		 var taskbarItems=['Home','Attendance','Leave Policy','Laptop Policy','Job Family','Performance','Domestic Travel','Bring A Buddy','Foreign Travel','Guest House','holiday List','I Card','Separation']
   	   		   var taskbarLinkPages=['HomeWidgets',"EmployeeHRPolicies","LeavePolicy","LaptopPolicy","JobFamily","PerformanceAppraisals","DomesticTravel","BringABuddy","ForeignTravelPolicy","GuestHousePolicy","holidaylist","ICardPolicy","SEPARATIONPOLICY"]
   		      $( ".taskbar-row" ).empty();
 	   		MasterJs.addTaskbar(13, taskbarItems, 'menu',taskbarLinkPages);
 	   	document.getElementById('DomesticTravel').classList.add('taskbar-celladd');
   	 	}
        	else if(clickid=="BringABuddy"){
        		 var taskbarItems=['Home','Attendance','Leave Policy','Laptop Policy','Job Family','Performance','Domestic Travel','Bring A Buddy','Foreign Travel','Guest House','holiday List','I Card','Separation']
   	   		   var taskbarLinkPages=['HomeWidgets',"EmployeeHRPolicies","LeavePolicy","LaptopPolicy","JobFamily","PerformanceAppraisals","DomesticTravel","BringABuddy","ForeignTravelPolicy","GuestHousePolicy","holidaylist","ICardPolicy","SEPARATIONPOLICY"]
   		      $( ".taskbar-row" ).empty();
 	   		MasterJs.addTaskbar(13, taskbarItems, 'menu',taskbarLinkPages);
 	      	document.getElementById('BringABuddy').classList.add('taskbar-celladd');
   	 	}
    	   
    	   
    	  
        	else if(clickid=="ForeignTravelPolicy"){
       		 var taskbarItems=['Home','Attendance','Leave Policy','Laptop Policy','Job Family','Performance','Domestic Travel','Bring A Buddy','Foreign Travel','Guest House','holiday List','I Card','Separation']
   	   		   var taskbarLinkPages=['HomeWidgets',"EmployeeHRPolicies","LeavePolicy","LaptopPolicy","JobFamily","PerformanceAppraisals","DomesticTravel","BringABuddy","ForeignTravelPolicy","GuestHousePolicy","holidaylist","ICardPolicy","SEPARATIONPOLICY"]
   		       $( ".taskbar-row" ).empty();
   	   		MasterJs.addTaskbar(13, taskbarItems, 'menu',taskbarLinkPages);
   	      	document.getElementById('ForeignTravelPolicy').classList.add('taskbar-celladd');
   	 	}
       	else if(clickid=="GuestHousePolicy"){
       		 var taskbarItems=['Home','Attendance','Leave Policy','Laptop Policy','Job Family','Performance','Domestic Travel','Bring A Buddy','Foreign Travel','Guest House','holiday List','I Card','Separation']
   	   		   var taskbarLinkPages=['HomeWidgets',"EmployeeHRPolicies","LeavePolicy","LaptopPolicy","JobFamily","PerformanceAppraisals","DomesticTravel","BringABuddy","ForeignTravelPolicy","GuestHousePolicy","holidaylist","ICardPolicy","SEPARATIONPOLICY"]
   		       $( ".taskbar-row" ).empty();
   	   		MasterJs.addTaskbar(13, taskbarItems, 'menu',taskbarLinkPages);
   	      	document.getElementById('GuestHousePolicy').classList.add('taskbar-celladd');
   	 	}
       	else if(clickid=="holidaylist"){
       		 var taskbarItems=['Home','Attendance','Leave Policy','Laptop Policy','Job Family','Performance','Domestic Travel','Bring A Buddy','Foreign Travel','Guest House','holiday List','I Card','Separation']
   	   		   var taskbarLinkPages=['HomeWidgets',"EmployeeHRPolicies","LeavePolicy","LaptopPolicy","JobFamily","PerformanceAppraisals","DomesticTravel","BringABuddy","ForeignTravelPolicy","GuestHousePolicy","holidaylist","ICardPolicy","SEPARATIONPOLICY"]
   		       $( ".taskbar-row" ).empty();
   	   		MasterJs.addTaskbar(13, taskbarItems, 'menu',taskbarLinkPages);
   	      	document.getElementById('holidaylist').classList.add('taskbar-celladd');
   	 	}
       	else if(clickid=="ICardPolicy"){
       		 var taskbarItems=['Home','Attendance','Leave Policy','Laptop Policy','Job Family','Performance','Domestic Travel','Bring A Buddy','Foreign Travel','Guest House','holiday List','I Card','Separation']
   	   		   var taskbarLinkPages=['HomeWidgets',"EmployeeHRPolicies","LeavePolicy","LaptopPolicy","JobFamily","PerformanceAppraisals","DomesticTravel","BringABuddy","ForeignTravelPolicy","GuestHousePolicy","holidaylist","ICardPolicy","SEPARATIONPOLICY"]
   			       $( ".taskbar-row" ).empty();
   	   		MasterJs.addTaskbar(13, taskbarItems, 'menu',taskbarLinkPages);
   	      	document.getElementById('ICardPolicy').classList.add('taskbar-celladd');
   	 	}
       	else if(clickid=="SEPARATIONPOLICY"){
       		   var taskbarItems=['Home','Attendance','Leave Policy','Laptop Policy','Job Family','Performance','Domestic Travel','Bring A Buddy','Foreign Travel','Guest House','holiday List','I Card','Separation']
   		   		   var taskbarLinkPages=['HomeWidgets',"EmployeeHRPolicies","LeavePolicy","LaptopPolicy","JobFamily","PerformanceAppraisals","DomesticTravel","BringABuddy","ForeignTravelPolicy","GuestHousePolicy","holidaylist","ICardPolicy","SEPARATIONPOLICY"]
   			       $( ".taskbar-row" ).empty();
   	   		MasterJs.addTaskbar(13, taskbarItems, 'menu',taskbarLinkPages);
   	      	document.getElementById('SEPARATIONPOLICY').classList.add('taskbar-celladd');
   	 	}
    	   
    	   
    	   
    	   
    	   
    	   
    	   
    	   
    	   
    	   
    	   
    	   else if(clickid=="DLMS"){
        		  var taskbarItems=['Home','DLMS','F Poly Phase','M Poly Phase','M.S. Phase','Poly Phase DLMS','Poly Phase H.V','Poly Phase V',]
       		   		   var taskbarLinkPages=['HomeWidgets',"DLMS","FirmwarePolyPhase","MechanicalPolyPhase","MechanicalSinglePhase","PolyPhaseDLMS","PolyPhasehardwarevalidation","PolyPhaseValidation",]
 			       $( ".taskbar-row" ).empty();
 	   		MasterJs.addTaskbar(8, taskbarItems, 'menu',taskbarLinkPages);
 	   	document.getElementById('DLMS').classList.add('taskbar-celladd');
 	 	}
        	else if(clickid=="FirmwarePolyPhase"){
        		  var taskbarItems=['Home','DLMS','F Poly Phase','M Poly Phase','M.S. Phase','Poly Phase DLMS','Poly Phase H.V','Poly Phase V',]
       		   		   var taskbarLinkPages=['HomeWidgets',"DLMS","FirmwarePolyPhase","MechanicalPolyPhase","MechanicalSinglePhase","PolyPhaseDLMS","PolyPhasehardwarevalidation","PolyPhaseValidation",]
 			       $( ".taskbar-row" ).empty();
 	   		MasterJs.addTaskbar(8, taskbarItems, 'menu',taskbarLinkPages);
 	   	document.getElementById('FirmwarePolyPhase').classList.add('taskbar-celladd');
 	 	}
        	else if(clickid=="MechanicalPolyPhase"){
        		  var taskbarItems=['Home','DLMS','F Poly Phase','M Poly Phase','M.S. Phase','Poly Phase DLMS','Poly Phase H.V','Poly Phase V',]
       		   		   var taskbarLinkPages=['HomeWidgets',"DLMS","FirmwarePolyPhase","MechanicalPolyPhase","MechanicalSinglePhase","PolyPhaseDLMS","PolyPhasehardwarevalidation","PolyPhaseValidation",]
 			       $( ".taskbar-row" ).empty();
 	   		MasterJs.addTaskbar(8, taskbarItems, 'menu',taskbarLinkPages);
 	    	document.getElementById('MechanicalPolyPhase').classList.add('taskbar-celladd');
 	 	}
        	else if(clickid=="MechanicalSinglePhase"){
        		  var taskbarItems=['Home','DLMS','F Poly Phase','M Poly Phase','M.S. Phase','Poly Phase DLMS','Poly Phase H.V','Poly Phase V',]
       		   		   var taskbarLinkPages=['HomeWidgets',"DLMS","FirmwarePolyPhase","MechanicalPolyPhase","MechanicalSinglePhase","PolyPhaseDLMS","PolyPhasehardwarevalidation","PolyPhaseValidation",]
 			       $( ".taskbar-row" ).empty();
 	   		MasterJs.addTaskbar(8, taskbarItems, 'menu',taskbarLinkPages);
 	   	document.getElementById('MechanicalSinglePhase').classList.add('taskbar-celladd');
 	 	}
        	else if(clickid=="PolyPhaseDLMS"){
        		  var taskbarItems=['Home','DLMS','F Poly Phase','M Poly Phase','M.S. Phase','Poly Phase DLMS','Poly Phase H.V','Poly Phase V',]
       		   		   var taskbarLinkPages=['HomeWidgets',"DLMS","FirmwarePolyPhase","MechanicalPolyPhase","MechanicalSinglePhase","PolyPhaseDLMS","PolyPhasehardwarevalidation","PolyPhaseValidation",]
 			       $( ".taskbar-row" ).empty();
 	   		MasterJs.addTaskbar(8, taskbarItems, 'menu',taskbarLinkPages);
 	    	document.getElementById('PolyPhaseDLMS').classList.add('taskbar-celladd');
 	 	}
        	else if(clickid=="PolyPhasehardwarevalidation"){
        		  var taskbarItems=['Home','DLMS','F Poly Phase','M Poly Phase','M.S. Phase','Poly Phase DLMS','Poly Phase H.V','Poly Phase V',]
       		   		   var taskbarLinkPages=['HomeWidgets',"DLMS","FirmwarePolyPhase","MechanicalPolyPhase","MechanicalSinglePhase","PolyPhaseDLMS","PolyPhasehardwarevalidation","PolyPhaseValidation",]
 			       $( ".taskbar-row" ).empty();
 	   		MasterJs.addTaskbar(8, taskbarItems, 'menu',taskbarLinkPages);
 	   	document.getElementById('PolyPhasehardwarevalidation').classList.add('taskbar-celladd');
 	 	}
        	else if(clickid=="PolyPhaseValidation"){
      		   var taskbarItems=['Home','DLMS','F Poly Phase','M Poly Phase','M.S. Phase','Poly Phase DLMS','Poly Phase H.V','Poly Phase V',]
 		   		   var taskbarLinkPages=['HomeWidgets',"DLMS","FirmwarePolyPhase","MechanicalPolyPhase","MechanicalSinglePhase","PolyPhaseDLMS","PolyPhasehardwarevalidation","PolyPhaseValidation",]
 			       $( ".taskbar-row" ).empty();
 	   		MasterJs.addTaskbar(8, taskbarItems, 'menu',taskbarLinkPages);
 	     	document.getElementById('PolyPhaseValidation').classList.add('taskbar-celladd');
 	 	}
    	   
      	 else{
      		 var cars = ['Home'];
          	 var carlink = ['HomeWidgets'];
          	 $( ".taskbar-row" ).empty();
          	 MasterJs.addTaskbar(1, cars, 'menu', carlink);
      	 }
    	   
    	   }
	}
});


