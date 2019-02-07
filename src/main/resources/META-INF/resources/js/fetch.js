function getFromJSON(endpoint) {
    return fetch(endpoint)
        .then(r => r.json())
        .then(JSON.stringify);
}

function getFromSSE(endpoint) {
    return fetch(endpoint)
        .then(r => r.arrayBuffer())
        .then(r => { return console.log(r), r})
        .then(ar => {
            const result = [];
            for (let i = 0; i < ar.byteLength; i++) {
                result.push(String.fromCharCode(ar[i]));
            }
            return result.join('');
        })
        .catch(console.error);
}

function writeTo(element, content) {
    element.innerHTML += content.toString();
}

getFromJSON('/objects')
    .then(response => writeTo(document.querySelector("#flat"), response));
getFromJSON('/objects/flux')
    .then(response => writeTo(document.querySelector("#flux"), response));
getFromSSE('/objects/sse')
    .then(response => writeTo(document.querySelector("#sse"), response));
getFromSSE('/objects/sse/annotated')
    .then(response => writeTo(document.querySelector("#sse-annotated"), response));
