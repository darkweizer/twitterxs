<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<title><spring:message code="user.create.title"/></title>
	</head>
	
	<body>
		<section>
		
			<h1>
				<spring:message code="user.create.title"></spring:message>
			</h1>
		
			<form:form action="save" method="POST" modelAttribute="user">

				
				<form:label path="firstname"><spring:message code="user.create.firstname"/></form:label>
				<form:input path="firstname" maxlength="100" />
				<form:errors element="div" path="firstname"/>
				
				<form:label path="lastname"><spring:message code="user.create.lastname"/></form:label>
				<form:input path="lastname" maxlength="100" />
				<form:errors element="div" path="lastname"/>
				
				<form:label path="email"><spring:message code="user.create.email"/></form:label>
				<form:input path="email" maxlength="255" />
				<form:errors element="div" path="email"/>
				
				<form:label path="birthDate"><spring:message code="user.create.birthDate"/></form:label>
				<form:input path="birthDate"/>
				<form:errors element="div" path="birthDate"/>
								

				<form:label path="regionId"><spring:message code="user.create.region"/></form:label>
				<form:select path="regionId">
					<form:option value=""><spring:message code="user.create.region.choose"></spring:message></form:option>
					<form:options items="${regions}" itemValue="value" itemLabel="label"/>
				</form:select>
				<form:errors element="span" path="regionId"/>


				<form:label path="security.username"><spring:message code="user.create.username"/></form:label>
				<form:input path="security.username" maxlength="50" />
				<form:errors element="div" path="security.username"/>
				
				<form:label path="security.password"><spring:message code="user.create.password"/></form:label>
				<form:password path="security.password" maxlength="10" autocomplete="off" />
				<form:errors element="div" path="security.password"/>
				
				<form:button><spring:message code="user.create.user"/></form:button>
				
			</form:form>

		</section>
	</body>
</html>