let c = rxjs.defer(() => fetch('/objects'));
c.subscribe(
    response => {
        console.log('NEXT!', response);
        response.body.getReader().read()
            .then(r => r.value)
            .then(ar => {
                const result = [];
                for (let a of ar) {
                    result.push(String.fromCharCode(a));
                }
                return result.join('');
            })
            .then(console.log);
    },
    err => console.error('ERROR!', err),
    () => console.warn('COMPLETED!')
);

