const eventSource = new EventSource('/objects');
eventSource.addEventListener('open', e => console.log('OPEN!', e), false);
eventSource.addEventListener('message', e => console.log('MESSAGE!', e), false);
eventSource.addEventListener(
    'error',
    e => {
        console.log('ERROR!', e);
        eventSource.close();
    },
    false);
