import Layout from '@/layout'
import questionRouter from './question'
const adminRouter = {
  path: '/admin',
  component: Layout,
  redirect: '/admin/dashboard',
  name: 'admin',
  meta: {
    title: '관리자'
  },
  children: [
    {
      path: 'dashboard',
      component: () => import('@/views/admin/dashboard'),
      name: '관리자 메인',
      meta: {
        title: '관리자 메인'
      },
      roles: ['admin']
    },
    questionRouter,
    {
      path: 'notice',
      component: () => import('@/views/admin/notice'),
      name: '공지사항 관리',
      meta: {
        title: '공지사항 관리'
      },
      roles: ['admin']
    },
    {
      path: 'license',
      component: () => import('@/views/admin/license'),
      name: '자격증 관리',
      meta: {
        title: '자격증 관리'
      },
      roles: ['admin']
    },
    {
      path: 'user',
      component: () => import('@/views/admin/user'),
      name: '회원 관리',
      meta: {
        title: '회원 관리'
      },
      roles: ['admin']
    }
  ]
}
export default adminRouter
