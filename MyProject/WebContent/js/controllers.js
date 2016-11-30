angular.module("Collaboration.controllers").controller("ChatCtrl", function($scope, ChatService) {
  $scope.messages = [];
  $scope.message = "";
  $scope.max = 140;
  $scope.i = 0;
  
  $scope.addMessage = function() {
	  console.log("addMessage in controller");
	  ChatService.send($scope.message);
      $scope.message = "";
  };

  ChatService.receive().then(null, null, function(message) {
	  console.log("receive in controller");
    $scope.messages.push(message);
  });
  
});