[1, 2, 3, 4].forEach(id => {
    document.getElementById("btn" + id).onclick = function () {
        client.send('/app/play', {}, JSON.stringify({"instrument": "aud" + id}));

    }
})

window.onload = function () {
    var socket = new SockJS('/music-mania');  // create a websocket connection
    client = Stomp.over(socket);   // wraps socket into Stomp object
    client.connect({}, function () {
        client.subscribe('/instruments/play', function (data) {
            let body = JSON.parse(data.body);
            document.getElementById(body.instrument).play();
        })
    })
}
