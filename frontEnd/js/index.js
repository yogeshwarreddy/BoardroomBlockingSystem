angular.module("index", ["ngRoute"]);

angular.module("index").controller("requestController", function ($scope, $routeParams, $http, auth) {
  $http.get("/api/request/" + $routeParams.id).then(function (response) {
    $scope.request = response.data;
    console.dir(response);
  }).catch(function (error) {
    console.log("error fetching request data");
  })
  $http.get("/api/rooms?branchId=" + auth.getUser().branch.id).then(
    function (response) {
      $scope.rooms = response.data;
    }
  ).catch(function (error) {
    $scope.rooms = [];
  });
});
angular.module("index").controller("roomController", function ($rootScope, $scope) {
});
angular.module("index").controller("adminController", function ($rootScope, $scope) {
});
angular.module("index").controller("requestsController", function ($rootScope, $scope, $http) {
  $http.get("/api/requests").then(function (response) {
    $scope.requests = response.data;
    $scope.requests.forEach(request => {
      request.from_time = new Date(request.startTime).toLocaleString();
      request.to_time = new Date(request.endTime).toLocaleTimeString();
    });
  }, function (response) {
    console.log("error in get rooms");
    $scope.requests = [];
  });
});


/*===============================================================================================
 
                Standard js scripts
 
===============================================================================================*/
$('.datepicker').pickadate({
  selectMonths: true, // Creates a dropdown to control month
  selectYears: 15, // Creates a dropdown of 15 years to control year,
  today: 'Today',
  clear: 'Clear',
  close: 'Ok',
  closeOnSelect: false // Close upon selecting a date,
});
$('.timepicker').pickatime({
  default: 'now', // Set default time: 'now', '1:30AM', '16:30'
  fromnow: 0,       // set default time to * milliseconds from now (using with default = 'now')
  twelvehour: false, // Use AM/PM or 24-hour format
  donetext: 'OK', // text for done-button
  cleartext: 'Clear', // text for clear-button
  canceltext: 'Cancel', // Text for cancel-button
  autoclose: false, // automatic close timepicker
  ampmclickable: true, // make AM PM clickable
  aftershow: function () { } //Function for after opening timepicker
});
