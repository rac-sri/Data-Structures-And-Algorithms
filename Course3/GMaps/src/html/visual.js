var delay = 300;
var map, positions;
var markers = [];

var markerURL = "http://maps.google.com/mapfiles/kml/paddle/red-diamond-lv.png";
function visualizeSearch(mapParam, latLongs) {
	positions = latLongs;
	map = mapParam;
	drop();
	return markers;
}

function displayMarker(latLng, timeout) {
	window.setTimeout(function() {
		markers.push(new google.maps.Marker({
			map: map,
			icon: markerURL,
			position: latLng,
			//animation: google.maps.Animation.DROP
			animation: null
		}))
	}, timeout);
}

function drop() {
	for(var i = 1; i < positions.length - 1; ++i) {
		displayMarker(positions[i], i*delay);
	}
}


function clearMarkers() {
	for(var i = 0; i < markers.length; ++i) {
		markers[i].setMap(null);
	}

}