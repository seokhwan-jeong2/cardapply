
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import ApplyApplyManager from "./components/listers/ApplyApplyCards"
import ApplyApplyDetail from "./components/listers/ApplyApplyDetail"

import SendSendManager from "./components/listers/SendSendCards"
import SendSendDetail from "./components/listers/SendSendDetail"

import LimitLimitManager from "./components/listers/LimitLimitCards"
import LimitLimitDetail from "./components/listers/LimitLimitDetail"

import CustomerCustomerManager from "./components/listers/CustomerCustomerCards"
import CustomerCustomerDetail from "./components/listers/CustomerCustomerDetail"

import MypageMyPageManager from "./components/listers/MypageMyPageCards"
import MypageMyPageDetail from "./components/listers/MypageMyPageDetail"


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
                path: '/sends/sends',
                name: 'SendSendManager',
                component: SendSendManager
            },
            {
                path: '/sends/sends/:id',
                name: 'SendSendDetail',
                component: SendSendDetail
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

            {
                path: '/mypages/myPages',
                name: 'MypageMyPageManager',
                component: MypageMyPageManager
            },
            {
                path: '/mypages/myPages/:id',
                name: 'MypageMyPageDetail',
                component: MypageMyPageDetail
            },



    ]
})
