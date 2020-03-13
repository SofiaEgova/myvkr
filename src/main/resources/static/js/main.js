var messageApi=Vue.resource('/message{/id}');

Vue.component('message-form', {
    props:['messages'],
    data: function (){
        return{
            text:''
        }
    },
    template: '<div>' +
        '<input type = "text" placeholder="write" v-model="text"/>' + //v-model="text" попадает в возвращаемое значение
        '<input type = "button" value="save" @click="save"/>' +
        '</div>',
    methods:{
        save: function () {
            var message = {text:this.text};
            messageApi.save({}, message).then(res=>
                res.json().then(data=>{
                    this.messages.push(data);
                    this.text="";
                })
            )
        }
    }
});

Vue.component('message-row', {
    props: ['message'],
    template:'<div>{{message.text}}</div>'
});

// получает с сервера через messageApi данные и отображает на странице через app
Vue.component('messages-list', {
    props: ['messages'],
    template: '<div>' +
        '<message-form :messages="messages"/>'+
        '<message-row v-for="message in messages" :key="message.id" :message="message"></message-row>' +
        '</div>',
    created: function () {
        messageApi.get().then(res=>
            res.json().then(data=>
                data.forEach(message=> this.messages.push(message))
            )
        )
    }
});

var app = new Vue({
    el: '#app',  //id div
    template: '<messages-list :messages="messages"/>',
    data: {
        messages: [

        ]
    }
});