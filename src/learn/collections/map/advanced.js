function Student(name,age){
    if(this instanceof Student){
        this.name = name;
        this.age = age;
    }else{
        return new Student(name,age);
    }
}
function GoodStudent(score,glass){
    Student.call(this,"gaara",21);
    this.score = score;
    this.glass = glass;
}

var gaara = new GoodStudent(100,"yanjing");
alert(gaara.name);

function curry(fn){
    var args = Array.prototype.slice.call(arguments,1);
    return function(){
        var innerArgs = Array.prototype.slice.call(arguments);
        var finalArgs = args.concat(innerArgs);
        return fn.apply(null, finalArgs);
    };
}


/*
function creatXHR(){
    if(typeof XMLHttpRequest != "undefined"){
        createXHR = function(){
            return new XMLHttpRequest();
        }
    }else if{
        createXHR = function(){
            if(typeof arguments.callee.activeXString != "string"){
                var versions = ["MSXML2.XMLHttp.6.0","MSXML2.XMLHttp.3.0","MSXML2.XMLHttp"];
                for(var i = 0; i < versions.length; i ++){
                    try{
                        var xhr = new ActiveXObject(versions[i]);
                        
                    }catch(ex){
                    
                    }
                }
            }
            return new ActiveXObject(arguments.callee.activeString();    
        };
    }else{
        creatXHR = function{
            throw new Error("No XHR object available");
        }
    }
}
*/

setTimeout(function(){
    var userbar = document.getElementById("userbar");
    var left = parseInt(userbar.style.left) + 5;
    userbar.style.left = left;
    if (left < 200){
        setTimeout(arguments.callee, 50);
    }
},50)

function chunck(data,process){
    setTimeout(function(){
        var content = data.shift();
        process.call(this,content);
        if(data.length > 0){
            setTimeout(arguments.callee, 100);
        }
    }, 100)
}

var data = [1,2,3,4,44,3,3,11,221,2222,4111,423,421,44]

function printValue(content){
    alert(content);
}

chunck(data.concat(), printValue);

//º¯Êý½ÚÁ÷
var processor = {
    timeoutId: null,
    perforceProcess: function(){
        //Êµ¼ÊÒªÖ´ÐÐµÄ´úÂë
    },
    process:function(){
        clearTimeout(this.timeoutId);
        var that = this;
        this.timeoutId = setTimeout(function(){
            that.perforceProcess();
        },100);
    }
}
//³¢ÊÔ¿ªÊ¼Ö´ÐÐ
processor.process();


var o = document.createElement("div");
with(o){
    style.cursor = "pointer";
    style.color = "blue";
    innerHTML = "aaa";
}
document.appendChild(o);

/*==============¸ß¼¶³ÌÐòÉè¼Æ ¼Ì³Ð ¿ªÊ¼ ==================*/
//¼ÄÉú×éºÏÊ½¼Ì³Ð
function inheritPrototype(subType, superType){
    var prototype = Object(superType.prototype);//´´½¨
    prototype.constructor = subType;            //ÔöÇ¿
    subType.prototype = prototype;              //Ö¸¶¨
}


/*==============¸ß¼¶³ÌÐòÉè¼Æ ¼Ì³Ð ½áÊø ==================*/



/*------------------------------javascriptÓïÑÔ¾«´â µÚËÄÕÂ¿ªÊ¼----------------------*/
var add = function(num1,num2){ return num1 + num2;}

var myObject = {
    value: 0,
    increment: function(inc){
        this.value += typeof inc === 'number' ? inc : 1;
    }
};

myObject.double = function(){
    var that = this;
    var helper = function(){
        that.value = add(that.value, that.value);
    };
    helper();
}

myObject.double();

var array = [3,4];
var sumResult = add.apply(null, array);

var myStatus = {status:"ssssssssss"}
Quo.prototype.getStatus.apply(myStatus);
/*------------------------------javascriptÓïÑÔ¾«´â µÚËÄÕÂ½áÊø----------------------*/

/*==========================×Ô¶¨ÒåÊÂ¼þ¿ªÊ¼P474 ==========================*/
//×Ô¶¨ÒåÊÂ¼þ¶ÔÏó
function EventTarget(){
    this.handlers = {};
}

EventTarget.prototype = {
    constructor: EventTarget,
    addHandler: function(type, handler){
        if(typeof this.handlers[type] == "undefined"){
            this.handlers[type] = [];
        }
        this.handlers[type].push(handler);
    },
    fire: function(event){
        if(!event.target){
            event.target = this;
        }
        if(this.handlers[event.type] instanceof Array){
            var handlers = this.handlers[event.type];
            for(var i = 0; i < handlers.length; i++){
                handlers[i](event);
            }
        }
    },
    removeHandler: function(type, handler){
        if(this.handlers[type] instanceof Array){
            var handlers = this.handlers[type];
            for(var i = 0; i < handlers.length; i++){
                if(handlers[i] === handler){
                    break;
                }
            }
            handlers.splice(i,1);
        }
    }
}
//µ÷ÓÃ¶¨ÒåÊÂ¼þº¯Êý
function handleMessage(event){
    console.info("Message Received:" + event.message);
}

var target = new EventTarget();

target.addHandler("message", handleMessage);
target.fire({type: "message", message: "HelloWorld"});
target.removeHandler("message", handleMessage);
target.fire({type: "message", message: "HelloWorld"}); //µ÷ÓÃÊ§°Ü£¬ÒÑ¾­±»ÒÆ³ý
//×Ô¶¨ÒåÊÂ¼þÓëÆäËû¶ÔÏó°ó¶¨
function Person(name,age){
    EventTarget.call(this);
    this.name = name;
    this.age = age;
}
inheritPrototype(Person, EventTarget);
Person.prototype.say = function(message){
    this.fire({type: "messsage", message: message});
};
function personHandleMessage(event){
    alert(event.target.name + " says " + event.message);
}
var person = new Person("nicholas", 29);
person.addHandler("message", personHandleMessage);
person.say("Hi i am nicholas! nice to meet you");



//=====================×Ô¶¨ÒåÊÂ¼þ½áÊø ==============================

