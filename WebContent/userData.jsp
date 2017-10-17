<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<div ng-app>
<div class="row">
    <div class="col-lg-12 text-center">
        <h2>User Data</h2>
        <hr class="star-primary">
    </div>
</div>

        
<div>
    <div class="col-lg-2">
        <img src="img/profile.png" alt="" class="img-rounded img-responsive" />
    </div>
    <div class="col-lg-6 pull-left">
        <h4>${user.name}</h4>
        <p>
            <i class="glyphicon glyphicon-envelope"></i>${user.email}
            <br />
            <i class="glyphicon glyphicon-globe"></i>${user.shortName}
            <br />
            <i class="glyphicon glyphicon-gift"></i>${user.role}</p>
        <!-- Split button -->
        <div class="btn-group" ng-controller="logoutCtrl">
        	<c:if test="${user.role eq 'scrutinizer'}">
            <a href="scrutinizer.html#!/" class="btn btn-info">Scrutinizer Role</a>
            </c:if>
            <button type="button" class="btn btn-primary" ng-click="timeline()">Timeline</button>
            <button type="button" class="btn btn-info" ng-click="showPayments()">Donations</button>
            <button type="button" class="btn btn-danger" ng-click="logout()">Logout</button>
        </div>
    </div>
</div>
            
</div>
