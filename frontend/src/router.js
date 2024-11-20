
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import ApplyApplyManager from "./components/listers/ApplyApplyCards"
import ApplyApplyDetail from "./components/listers/ApplyApplyDetail"

import Manager from "./components/listers/Cards"
import Detail from "./components/listers/Detail"

import LimitLimitManager from "./components/listers/LimitLimitCards"
import LimitLimitDetail from "./components/listers/LimitLimitDetail"

import CustomerCustomerManager from "./components/listers/CustomerCustomerCards"
import CustomerCustomerDetail from "./components/listers/CustomerCustomerDetail"


export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/applies/applies',
                name: 'ApplyApplyManager',
                component: ApplyApplyManager
            },
            {
                path: '/applies/applies/:id',
                name: 'ApplyApplyDetail',
                component: ApplyApplyDetail
            },

            {
                path: '//',
                name: 'Manager',
                component: Manager
            },
            {
                path: '///:id',
                name: 'Detail',
                component: Detail
            },

            {
                path: '/limits/limits',
                name: 'LimitLimitManager',
                component: LimitLimitManager
            },
            {
                path: '/limits/limits/:id',
                name: 'LimitLimitDetail',
                component: LimitLimitDetail
            },

            {
                path: '/customers/customers',
                name: 'CustomerCustomerManager',
                component: CustomerCustomerManager
            },
            {
                path: '/customers/customers/:id',
                name: 'CustomerCustomerDetail',
                component: CustomerCustomerDetail
            },



    ]
})
