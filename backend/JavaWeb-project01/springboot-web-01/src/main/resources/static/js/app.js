const { createApp } = Vue;

createApp({
    data() {
        return {
            userList: [],
            loading: true,
            error: null
        };
    },
    mounted() {
        this.fetchUsers();
    },
    methods: {
        fetchUsers() {
            axios.get('/list')
                .then(response => {
                    this.userList = response.data;
                    this.loading = false;
                })
                .catch(error => {
                    this.error = '加载用户数据失败：' + (error.message || '未知错误');
                    this.loading = false;
                    console.error('Error fetching users:', error);
                });
        }
    }
}).mount('#app');