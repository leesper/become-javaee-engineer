const request = require('./request')

// 基础数据
// const baseCitys = data => request('post', `/base/citys/`, data)
const baseCities = data => request('post', `/commons/cities/`, data, true)
const baseSubjects = data => request('get', '/commons/courseList', data, true)

// 用户数据
const userLogin = data => request('post', '/member/login', data, true)
const userCenter = data => request('get', '/member/center', data, true)

// 面试题数据
const questionsConfirm = data => request('post', `/member/setCityCourse`, data, true)

const questionsFavorite = data => request('post', `/questions/favorite/${data.id}`, data)

const questionsCategorys = data => request('post', `/category/list`, data, true)

const questionsList = data => request('post', `/category/questions/list`, data, true)

const questionsCommmitOne = data => request('post', `/category/questions/commit`, data, true)

const questionsCommmitBatch = data => request('post', `/questions/category/${data.categoryID}/${data.categoryKind}/${data.categoryType}`, data)
const questionsEmpty = data => request('post', `/questions/empty/${data.categoryID}/${data.categoryKind}/${data.categoryType}`, data)

module.exports = {
  baseCities,
  baseSubjects,
  userLogin,
  userCenter,
  questionsConfirm,
  questionsFavorite,
  questionsCategorys,
  questionsList,
  questionsCommmitOne,
  questionsCommmitBatch,
  questionsEmpty
}
