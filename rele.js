
setInterval(() => {}, 1 << 30);

var Gpio = require('onoff').Gpio;
var rele1 = new Gpio(4, 'out');
var rele2 = new Gpio(22, 'out');
var rele3 = new Gpio(6, 'out');
var rele4 = new Gpio(26, 'out');

const myArgs = process.argv.slice(2);
console.log('myArgs: ', myArgs);

if(myArgs.includes('1')){
    rele1.writeSync(1);
}
if(myArgs.includes('2')){
    rele2.writeSync(1);
}
if(myArgs.includes('3')){
    rele3.writeSync(1);
}
if(myArgs.includes('4')){
    rele4.writeSync(1);
}

function unexportOnClose() {
  rele1.writeSync(0);
  rele1.unexport();
  rele2.writeSync(0);
  rele2.unexport();
  rele3.writeSync(0);
  rele3.unexport();
  rele4.writeSync(0);
  rele4.unexport();
};

process.on('SIGINT', unexportOnClose);