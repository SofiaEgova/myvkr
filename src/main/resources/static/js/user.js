var imageApi=Vue.resource('/vkr{/id}');

Vue.component('image-form', {
    props:['images'],
    data: function (){
        return{
            link:''
        }
    },
    template: '<div>' +
        '<input type = "text" placeholder="link" v-model="link"/>' + //v-model="text" попадает в возвращаемое значение
        '<input type = "button" value="save" @click="save"/>' +
        '</div>',
    methods:{
        save: function () {
            var image = {link:this.link};
            imageApi.save({}, image).then(res=>
                res.json().then(data=>{
                    this.images.push(data);
                    this.link="";
                })
            )
        }
    }
});

Vue.component('image-row', {
    props: ['image'],
    template:'<div>{{image.link}}</div>'
});

// получает с сервера через messageApi данные и отображает на странице через app
Vue.component('images-list', {
    props: ['images'],
    template: '<div>' +
        '<image-form :images="images"/>'+
        '<image-row v-for="image in images" :key="image.id" :image="image"></image-row>' +
        '</div>',
    created: function () {
        imageApi.get().then(res=>
            res.json().then(data=>
                data.forEach(image=> this.images.push(image))
            )
        )
    }
});

var app = new Vue({
    el: '#images',  //id div
    template: '<images-list :images="images"/>',
    data: {
        images: [
        ]
    }
});