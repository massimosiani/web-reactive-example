fetch('/test').then(r => r.body.getReader().read())
    .then(p => p.value)
    .then(ar => {
        const result = [];
        for (let a of ar) {
            result.push(String.fromCharCode(a));
        }
        return result.join('');
    })
    .then(JSON.parse)
    .then(console.log);
