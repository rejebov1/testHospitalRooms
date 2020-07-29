<%@ page import="java.time.LocalDateTime" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Rooms Page</title>

    <style type="text/css">
        .tg {
            border-collapse: collapse;
            border-spacing: 0;
            border-color: #ccc;
        }

        .tg td {
            font-family: Arial, sans-serif;
            font-size: 14px;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #fff;
        }

        .tg th {
            font-family: Arial, sans-serif;
            font-size: 14px;
            font-weight: normal;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #f0f0f0;
        }

        .tg .tg-4eph {
            background-color: #f9f9f9
        }
    </style>
</head>
<body>

<h1>Rooms List</h1>

<c:if test="${!empty roomList}">
    <table class="tg">
        <tr>
            <th width="80">Ticket</th>
            <th width="120">Manipulation</th>
            <th width="120">Start time</th>
            <th width="120">Worker position</th>
            <th width="60">Stop manipulation</th>
        </tr>
        <c:forEach items="${roomList}" var="room">
            <tr>
                <td>${room.id}</td>
                <td><a href="/roomdetails/${room.id}" target="_blank">${room.description}</a></td>
                <td>${room.localTime}</td>
                <td>${room.user}</td>
                <td><a href="<c:url value='/remove/${room.id}'/>">Stop manipulation</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>


<h1>Add Room</h1>

<c:url var="addAction" value="/room/add"/>

<form:form action="${addAction}" modelAttribute="room">
    <table>
        <c:if test="${!empty room.id}">
            <tr>
                <td>
                    <form:label path="id">
                        <spring:message text="Ticket"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="id" readonly="true" size="8" disabled="true"/>
                    <form:hidden path="id"/>
                </td>
            </tr>
        </c:if>
        <tr>
            <td>
                <form:label path="description">
                    <spring:message text="Manipulation"/>
                </form:label>
            </td>
            <td>
                <form:input path="description"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="user">
                    <spring:message text="Worker position"/>
                </form:label>
            </td>
            <td>
                <form:input path="user"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${empty room.description}">
                    <input type="submit"
                           value="<spring:message text="Add Room"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>