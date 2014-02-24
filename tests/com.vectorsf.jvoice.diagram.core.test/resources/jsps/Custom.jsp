<%@ page language="java" contentType="application/vxml; charset=UTF-8" pageEncoding="UTF-8" %>

<vxml version="2.1" xmlns="http://www.w3.org/2001/vxml" 
xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xml:lang="es-ES"><form> 

 <!-- TODO: Add custom code here --> 

<block> 
<var name="_eventId" expr="'success'" /> 
<submit next="${flowExecutionUrl}" namelist="_eventId" /> 

</block> 
</form>

</vxml>