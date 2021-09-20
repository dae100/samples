(function(){
    
    var app = angular.module("myMusic", ["ui.router", "ui.bootstrap", "ngResource", "ngCookies", "ngAnimate"]);
        
    app.config(function($stateProvider, $httpProvider, $urlRouterProvider){

    	$urlRouterProvider.otherwise("/music");

		$stateProvider
			.state("music", { url:"/music", templateUrl:"products.html", controller:"ProductController" })
			.state("artists", { url:"/artists", templateUrl:"artists.html", controller:"ArtistController" })
			.state("recordLabels", { url:"/recordLabels", templateUrl:"recordLabels.html", controller:"RecordLabelController" });
		
	});
    
}());